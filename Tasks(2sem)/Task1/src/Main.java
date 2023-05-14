import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 1(3). Petrov Artem group 1.1 \n\nКласс для описания комплексных чисел. Реализовать основные арифметические\n" +
            "операции для комплексных чисел. Дополнительно реализовать аналог класса Math для\n" +
            "комплексных чисел с несколькими тригонометрическими функциями (в реализации\n" +
            "можно использовать стандартный класс Math).\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    static double readDoubleValueFromConsole() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            try {
                double res = Double.parseDouble(value);
                return res;
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", value);
            }
        }
    }

    public static void main(String[] args) {
        startProgram();
        print("Введите действительная часть: ");
        double re = readDoubleValueFromConsole();
        print("Введите мнимую часть числа: ");
        double im = readDoubleValueFromConsole();
        Complex complex = new Complex(re,im);
        Complex.pr(complex);
        System.out.printf("%.2f",Complex.sin(complex));


        BigDecimal a = new BigDecimal("1213213213231");
        BigDecimal b = new BigDecimal("4545");
        BigDecimal c = a.add(b);
        System.out.printf("%s\n", c.toString());

        Complex q = new Complex(1, 5);
        Complex w = new Complex(3, 5);
        Complex z = q.add(w)

    }
}