import java.util.Scanner;

public class Program {
    public static final String START_TEXT = "Task 2. Petrov Artem group 1.1 \n\n Определить, можно ли коробку со сторонами A1, B1, C1 поместить в другую\n" +
            "коробку со сторонами A2, B2, C2 или наоборот (т.е. поместить вторую коробку в\n" +
            "первую). Для того, чтобы одну коробку можно было поместить в другую, каждая из\n" +
            "соответствующих сторон одной коробки должна быть строго меньше сторон другой\n" +
            "коробки. Стороны коробок задаются в произвольном порядке. При размещении\n" +
            "коробок одна в другую коробки можно произвольным образом вращать. Реализовать\n" +
            "функцию проверки возможности размещения одной коробки в другой. Распечатать\n" +
            "ответ вида «Первая коробка помещается во второй», «Вторая коробка помещается в\n" +
            "первой» или «Коробки нельзя разместить одна в другой». Совет: прежде чем\n" +
            "сравнивать стороны, их необходимо упорядочить.\n\n";

    public static final String FIRST_ISSUE = "Результат: Первая коробка помещается во второй";

    public static final String SECOND_ISSUE = "Результат: Вторая коробка помещается в первой";

    public static final String THIRD_ISSUE = "Результат: Коробки нельзя разместить одна в другой";

    public static final String FIRST_BOX_TEXT = "Введите размеры первой коробки: ";

    public static final String SECOND_BOX_TEXT = "Введите размеры второй коробки: ";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static Integer COMPARISON(double a1, double b1, double c1, double a2, double b2, double c2) {
        double max1;
        double avg1;
        double min1;
        double max2;
        double avg2;
        double min2;

        max1 = Math.max(Math.max(a1, b1), c1);
        min1 = Math.min(Math.min(a1, b1), c1);
        avg1 = a1 + b1 + c1 - max1 - min1;
        max2 = Math.max(Math.max(a2, b2), c2);
        min2 = Math.min(Math.min(a2, b2), c2);
        avg2 = a2 + b2 + c2 - max2 - min2;

        int res = 0;
        if ((max1 > max2) && (avg1 > avg2) && (min1 > min2)) {
            res = 2;
        } else {
            if ((max2 > max1) && (avg2 > avg1) && (min2 > min1)) {
                res = 1;
            }
        }
        if (res == 0) {
            res = 3;
        }
        return res;
    }

    public static void main(String[] args) {
        startProgram();
        Scanner scanner = new Scanner(System.in);
        print(FIRST_BOX_TEXT);
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double c1 = scanner.nextDouble();
        print(SECOND_BOX_TEXT);
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        double c2 = scanner.nextDouble();
        if (COMPARISON(a1, b1, c1, a2, b2, c2) == 1) {
            print(FIRST_ISSUE);
        } else {
            if (COMPARISON(a1, b1, c1, a2, b2, c2) == 2) {
                print(SECOND_ISSUE);
            } else {
                if (COMPARISON(a1, b1, c1, a2, b2, c2) == 3) {
                    print(THIRD_ISSUE);
                } else {
                    print("Error!");
                }
            }
        }
    }
}