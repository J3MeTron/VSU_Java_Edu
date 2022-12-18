import util.ArrayUtils;
import util.SwingUtils;
import util.UniversalUtils;

import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 10(16). Petrov Artem group 1.1 \n\n16.\tУпорядочить набор треугольников, заданных тремя вершинами, по площади (от меньшей к большей).\n\n";

    public static void startProgram() {
        UniversalUtils.print(START_TEXT);
    }

    public static double areaTriangle(int arr[][], int i) {
        double area = 0;
        area = 0.5 * (Math.abs((arr[i][2] - arr[i][0]) * (arr[i][5] - arr[i][1]) - (arr[i][4] - arr[i][0]) * (arr[i][2] - arr[i][1])));
        return area;
    }

    public static double[][] turn(double[][] massA) {
        double[][] result = new double[massA.length][massA[0].length];
        for (int i = 0; i < massA.length; i++) {
            for (int j = 0; j < massA.length; j++) {
                result[i][j] = massA[massA[0].length - 1 - j][i];
            }

        }
        return result;
    }

    public static int[][] comparison(int arrayT[][]) {

        double[][] destArray = new double[arrayT.length][arrayT[0].length + 1];

        for (int i = 0; i < destArray.length; i++) {
            for (int j = 0; j < destArray[i].length - 1; j++) {
                destArray[i][j] = arrayT[i][j];
            }
        }

        for (int i = 0; i < destArray.length; i++) {
            destArray[i][6] = (double) areaTriangle(arrayT, i);
        }

        Arrays.sort(destArray, Comparator.comparingDouble(arr -> arr[6]));
        for (int i = 0; i < destArray.length / 2; i++) {
            double[] tmp = destArray[i];
            destArray[i] = destArray[destArray.length - i - 1];
            destArray[destArray.length - i - 1] = tmp;
        }
        int[][] result = new int[arrayT.length][arrayT[0].length];
        for (int i = 0; i < arrayT.length; i++) {
            for (int j = 0; j < arrayT[i].length; j++) {
                result[i][j] = (int) destArray[i][j];
            }
        }

        return result;
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

    public static void outputAtFile(int[][] N) throws FileNotFoundException {
        ArrayUtils.writeArrayToFile("output.txt", N);
        UniversalUtils.print("Файл \"output.txt\" изменён!");
    }

    public static int[][] ArrayFromFile() throws FileNotFoundException {
        int[][] arr = ArrayUtils.readIntArray2FromFile("input.txt");
        for (int i = 1; i < arr.length; i++)
            if (arr[i].length != 6) {
                UniversalUtils.print("Не достаточно данных для вычислений! Попробуйте ещё раз!");
                System.exit(0);
            }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        startProgram();
        int n = 1;
        switch (n) {
            case 1:
                winMain();
                break;
            case 2:
                int[][] result = comparison(ArrayFromFile());
                outputAtFile(result);

        }


    }
}