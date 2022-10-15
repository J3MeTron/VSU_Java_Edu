import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 6(8). Petrov Artem group 1.1 \n\n При некоторых заданных x (допустимые значения x – интервал (-R, R)), n и e, определяемых вводом, вычислить:\n" +
            "\t1) сумму n слагаемых заданного вида;\n" +
            "\t2) сумму тех слагаемых, которые по абсолютной величине больше e;\n" +
            "\t3) сумму тех слагаемых, которые по абсолютной величине больше e/10;\n" +
            "\t4) значение функции с помощью методов Math.\n\n";

    public static final String BOX_TEXT_X = "Введите x (-1 < x < 1): ";
    public static final String BOX_TEXT_E = "Введите e > 0 ";
    public static final String BOX_TEXT_N = "Введите n > 0";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static double getNextElement(double previous, int index, double x, int col) {
        double res;
        if(index % 2 == 0) {
            res = -1 * (previous * x * (col/(col+1)));
        }
        else {
            res = previous * x * (col/(col+1));
        }
        return res;
    }

    public static void main(String[] args) {

        startProgram();

        Scanner scanner = new Scanner(System.in);

        print(BOX_TEXT_X);

        Float x = null;

        while (x == null) {
            try{
                float value = Float.parseFloat(scanner.next());
                if (value > 1 || value < -1) {
                    throw new Exception();
                }
                x = value;
            }catch (Exception e) {
                System.out.println("Число x не подходит по формату, попробуйте снова! \n");
            }
        }

        print(BOX_TEXT_E);

        Float ex = null;

        while (ex == null) {
            try{
                float value = Float.parseFloat(scanner.next());
                if (value <= 0) {
                    throw new Exception();
                }
                ex = value;
            }catch (Exception e) {
                System.out.println("Число e не подходит по формату, попробуйте снова! \n");
            }
        }

        print(BOX_TEXT_N);

        Integer n = null;


        while (n == null) {
            try{
                int value = Integer.parseInt(scanner.next());
                if (value < 1) {
                    throw new Exception();
                }
                n = value;
            }catch (Exception e) {
                System.out.println("Число x не подходит по формату, попробуйте снова! \n");
            }
        }

        double a = 1;
        int i = 1;
        int col = 1;

        double sumN = 0;
        double sumE = 0;
        double sumE10 = 0;

        while (true) {
            if (i <= n) {
                sumN += a;
            }

            if (Math.abs(a) > ex) {
                sumE += a;
            }

            if (Math.abs(a) > ex / 10) {
                sumE10 += a;
            }

            if (i > n && Math.abs(a) < ex / 10) {
                break;
            }

            a = getNextElement(a, i, x, col);
            col = col + 2;
            i++;
        }

        System.out.println("Sum N: " + sumN);
        System.out.println("Sum E: " + sumE);
        System.out.println("Sum E10: " + sumE10);
        System.out.println("Function: " + 1 / Math.sqrt(1+x));

    }

}