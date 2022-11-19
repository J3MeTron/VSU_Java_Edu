import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 7(10). Petrov Artem group 1.1 \n\nВводится массив целых чисел. \n" +
            "Найти максимальную сумму подряд идущих элементов. \n" +
            "Примечание: существует алгоритм, как можно получить такую сумму в один проход — постарайтесь догадаться.\n\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static int consoleArraySort(int[] arr) {
        int sum = 0;
        int max = 0;
        int sumA = 0;
        int answ = 0;
        int maxN = -1000;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            } else {
                if ((sum + arr[i]) > 0) {
                    sum += arr[i];
                } else {
                    sum = 0;
                }
                if(maxN < arr[i]){
                    maxN = arr[i];
                };
            }
            if (sum > max) {
                max = sum;
            }
        }
        if((sum <= 0) && (max <= 0)){
            answ = maxN;
        } else{
        answ = sum > max ? sum : max;
        }

        return (answ);
    }

    public static void consoleInputOutputArray2Test() {
        int[][] arr2 = new int[][]{{1, 2, 3, 5},
                {2, 4, -5, 1},
                {2, 3, -6, 1},
                {1, 2, -3, 3, 4},
                {2, 3, -3, 4}};

        for (int i = 0; i < 5; i += 1) {
            int answ = consoleArraySort(arr2[i]);

            System.out.printf("\"Обработанный\" массив:%n%s%n", ArrayUtils.toString(arr2[i]));

            print("Максимальная сумма: ");
            System.out.print(answ);
            print("\n\n");
        }
    }

    public static void consoleInputOutputArray2Keyboard() {
        int[] arr = ArrayUtils.readIntArrayFromConsole();

        if (arr.length == 0) {
            consoleInputOutputArray2Keyboard();
        }

        int answ = consoleArraySort(arr);
        // вывод массива
        System.out.printf("\"Обработанный\" массив:%n%s%n", ArrayUtils.toString(arr));

        print("Максимальная сумма: ");
        System.out.print(answ);
    }

    public static void consoleInputOutputArray2() {
        // ввод массива
        consoleInputOutputArray2Test();
        consoleInputOutputArray2Keyboard();
    }

    public static void main(String[] args) {
        startProgram();
        consoleInputOutputArray2();

    }
}