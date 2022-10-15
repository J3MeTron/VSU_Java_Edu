import java.util.Scanner;

public class Main {
    public static final String SMALL_R_TEXT = "Введите радиус малой окружности: ";
    public static final String BIG_R_TEXT = "Введите радиус большей окружности: ";
    public static final String START_TEXT = "Task 1. Petrov Artem group 1.1\nРадиус малой окружности r1, " +
            "большой – R2. Найти площадь заштрихованной части фигуры (рис. 2.4).\n";
    public static final String SQUARE_TEXT = "Площадь: %s";
    public static void startProgram() {
        System.out.printf(START_TEXT);
    }
    public static double calculations(double fr1, double fr2) {
        return ((2 * fr2) - ((Math.PI * (fr1 * fr1)) / 2)) + (Math.PI * (fr1 * fr1) / 8 * 6);
    }
    public static void print(String text) {
        System.out.print(text);
    }
    public static void print(String text, double square) {
        System.out.printf(text, square);
    }

    public static void main(String[] args) {
        startProgram();
        Scanner scanner = new Scanner(System.in);
        print(SMALL_R_TEXT);
        double r1 = scanner.nextDouble();
        print(BIG_R_TEXT);
        double r2 = scanner.nextDouble();
        double square = calculations(r1,r2);
        print(SQUARE_TEXT, square);
    }
}