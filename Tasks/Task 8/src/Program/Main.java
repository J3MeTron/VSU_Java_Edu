package Program;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static final String START_TEXT = "Task 8(12). Petrov Artem group 1.1 \n\nОсуществить циклический сдвиг столбцов или строк (указывается отдельно) двумерного массива на n позиций.\n\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    static int readIntegerValueOfChooseFromConsole() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            try {
                int res = Integer.parseInt(value);
                if ((res < 1) || (res > 2)) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", value);
            }
        }
    }

    static int readIntegerValueFromConsole() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            try {
                int res = Integer.parseInt(value);
                if (res <= 0) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", value);
            }
        }
    }

    public static void chooseCaseOffset() throws FileNotFoundException {
        print("Введите 1, если нужно сместить по строкам, 2, если по столбцам: ");
        int ch = readIntegerValueOfChooseFromConsole();
        print("Введите целое положительное число больще нуля N: ");
        int N = readIntegerValueFromConsole();

        switch (ch) {
            case (1):
                consoleArrayRowOffset(N);
                break;
            case (2):
                consoleArrayOffsetByColumns(N);
                break;
        }
    }

    public static void consoleArrayOffsetByColumns(int n) throws FileNotFoundException {
        int[][] arr = ArrayUtils.readIntArray2FromFile("input.txt");

        for (int i = 1; i < arr.length; i++)
            if (arr[i].length != arr[0].length) {
                print("Строки с разным кол-вом элементов, измените массив и запустите программу заново!");
                System. exit(0);
            }

        int bubble = 0;
        for (int N = n; N > 0; N--) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < (arr[i].length) - 1; j++) {
                    if (j == 0) {
                        bubble = arr[i][j + 1];
                        arr[i][j + 1] = arr[i][j];
                        arr[i][0] = bubble;
                    } else {
                        bubble = arr[i][j + 1];
                        arr[i][j + 1] = arr[i][0];
                        arr[i][0] = bubble;
                    }
                }
            }
        }

        ArrayUtils.writeArrayToFile("output.txt", arr, "");
        print("Файл \"output.txt\" изменён!");

    }

    public static void consoleArrayRowOffset(int n) throws FileNotFoundException {
        int[][] arr = ArrayUtils.readIntArray2FromFile("input.txt");
        for (int i = 1; i < arr.length; i++)
            if (arr[i].length != arr[0].length) {
                print("Строки с разным кол-вом элементов, измените массив и запустите программу заново!");
                System. exit(0);
            }
        int[][] arr2 = shiftDown(arr, n);

        ArrayUtils.writeArrayToFile("output.txt", arr2, "");
        print("Файл \"output.txt\" изменён!");
    }

    public static int[][] shiftDown(int[][] arr, int interval) {
        return Stream.concat(
                        Arrays.stream(arr, arr.length - interval, arr.length),
                        Arrays.stream(arr, 0, arr.length - interval))
                .toArray(int[][]::new);
    }


    public static void main(String[] args) throws FileNotFoundException {
        startProgram();
        chooseCaseOffset();
    }
}