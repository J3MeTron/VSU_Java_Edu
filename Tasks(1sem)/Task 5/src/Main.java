import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 5(8). Petrov Artem group 1.1 \n\n Напечатать в консоли следующие фигуры.\n\n";

    public static final String FIRST_BOX_TEXT = "Введите размеры фигуры (высота ширина): ";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void draw(int h, int w) {
        int curSpace = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i == 0 || i == h - 1) && j != 0 && j != w - 1) {
                    System.out.print("-");
                } else if (i != 0 && i != h - 1 && (j == 0 || j == w - 1)) {
                    System.out.print("|");
                } else if (((j > curSpace && j < w / 2) || (j < w - curSpace - 1 && j >= w / 2)) && (j != 0 && j != w - 1)) {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            curSpace++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        startProgram();
        print(FIRST_BOX_TEXT);
        Scanner scanner = new Scanner(System.in);

        Integer h = null;
        while (h == null) {
            try{
                int value = Integer.parseInt(scanner.next());

                if (value <= 3) {
                    throw new Exception();
                }

                h = value;
            }  catch (Exception e) {
                System.out.println("Число 2 не подходит по формату, попробуйте снова! \n");
            }
        }


        Integer w = null;
        while (w == null) {
            try{
                int value = Integer.parseInt(scanner.next());

                if (value <= 3) {
                    throw new Exception();
                }

                w = value;
            }  catch (Exception e) {
                System.out.println("Число 2 не подходит по формату, попробуйте снова! \n");
            }
        }

        draw(h, w);
    }
}