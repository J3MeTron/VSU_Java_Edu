import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 3(29). Petrov Artem group 1.1 \n\n Опеределите какого цвета будет в ведённая точка\n\n";

    public static final String FIRST_BOX_TEXT = "Введите координаты через пробел (x y): ";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

        public static void print(String text) {
            System.out.print(text);
        }

    public static final HorizontalParabola P1 = new HorizontalParabola(-1, -3, -0.5);

    public static final Line L2 = new Line(0, -15.5, -2.5);

    public static final Double X1 = 0.0;
    public static final Double Y1 = 0.0;

    public static final Double X2 = -2.0;
    public static final Double Y2 = -2.0;

    public static final Double X3 = -9.0;
    public static final Double Y3 = 0.0;

    public static final Double X4 = -4.0;
    public static final Double Y4 = -5.38;

    public static final Double X5 = 0.0;
    public static final Double Y5 = -8.0;

    public static final Double X6 = -4.0;
    public static final Double Y6 = -8.0;

    public static SimpleColor getColor(double x, double y) {

        if (P1.isPointRightOfParabola(x, y) & L2.isPointAboveLine(x, y) & y > -5) {
            return SimpleColor.ORANGE;
        }
        if (!P1.isPointRightOfParabola(x, y) & y < -5 & L2.isPointAboveLine(x, y)) {

            return SimpleColor.ORANGE;
        }
        if (y > -5 & !P1.isPointRightOfParabola(x, y) & L2.isPointAboveLine(x, y)) {
            return SimpleColor.GREEN;
        }
        if (P1.isPointRightOfParabola(x, y) & y < -5 & L2.isPointAboveLine(x, y)) {
            return SimpleColor.GREEN;
        }
        if (!P1.isPointRightOfParabola(x, y) & !L2.isPointAboveLine(x, y) & y < -5) {

            return SimpleColor.YELLOW;
        }

        return SimpleColor.GRAY;

    }

    public static void printColorForPoint(double x, double y) {


        System.out.printf("(%1$.2f; %2$.2f) => ", x, y);
        if (getColor(x, y) == SimpleColor.ORANGE) {
            print("ORANGE\n");
        } else {
            if (getColor(x, y) == SimpleColor.GREEN) {
                print("GREEN\n");
            } else {
                if (getColor(x, y) == SimpleColor.YELLOW) {
                    print("YELLOW\n");
                } else {
                    if (getColor(x, y) == SimpleColor.GRAY) {
                        print("GRAY\n");
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        startProgram();

        Scanner scanner = new Scanner(System.in);
        printColorForPoint(X1, Y1);
        printColorForPoint(X2, Y2);
        printColorForPoint(X3, Y3);
        printColorForPoint(X4, Y4);
        printColorForPoint(X5, Y5);
        printColorForPoint(X6, Y6);

        print(FIRST_BOX_TEXT);

        double x = scanner.nextDouble();
        double y = scanner.nextDouble();

        printColorForPoint(x, y);

    }
}