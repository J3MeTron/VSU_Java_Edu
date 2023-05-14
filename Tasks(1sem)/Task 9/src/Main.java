import util.ArrayUtils;
import util.ListUtils;
import util.SwingUtils;
import util.UniversalUtils;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 9(2). Petrov Artem group 1.1 \n\nОсуществить циклический сдвиг на n позиций(в обе стороны).\n\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static List<Integer> createNewList(List<Integer> numbers, int n, int[] arr) throws FileNotFoundException {

        for (int i = 0; i < arr.length; i++) {
            numbers.add(arr[i]);
        }

        int bubble = 0;
        if (n > 0) {
            for (int N = n; N > 0; N--) {
                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (i == 0) {
                        bubble = numbers.get(i + 1);
                        numbers.set(i + 1, numbers.get(i));
                        numbers.set(0, bubble);
                    } else {
                        bubble = numbers.get(i + 1);
                        numbers.set(i + 1, numbers.get(0));
                        numbers.set(0, bubble);
                    }
                }
            }
        } else {
            for (int N = n; N < 0; N++) {
                for (int i = 0; i < numbers.size() - 1; i++) {
                    if (i == 0) {
                        bubble = numbers.get(i);
                        numbers.set(i, numbers.get(i + 1));
                        numbers.set(i + 1, bubble);
                    } else {
                        bubble = numbers.get(i);
                        numbers.set(i, numbers.get(i + 1));
                        numbers.set(i + 1, bubble);
                    }
                }
            }

        }
        return numbers;
    }

    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void consoleProgram(int[] arr) throws FileNotFoundException {
        print("Введите целое число n. Если n > 0, то сдвиг происходит вправо, n < 0 – влево: ");
        int n = UniversalUtils.readIntegerValueOfChooseFromConsole();
        ArrayList<Integer> numbers = (ArrayList<Integer>) createNewList(new ArrayList<Integer>(), n, arr);
        ListUtils.ListIntToFile(numbers, "output.txt");
    }

    public static void main(String[] args) throws Exception {
        startProgram();
        int ch = 2;
        switch (ch) {
            case 1:
                int[] arr = ArrayUtils.readIntArrayFromFile("input.txt");
                consoleProgram(arr);
                break;
            case 2:
                winMain();

        }

    }


    public static <T> void printCollection(Collection<T> collection) {
        boolean first = true;
        for (T item : collection) {
            System.out.print((first ? "" : ", ") + item);
            first = false;
        }
        System.out.println();
    }

}
