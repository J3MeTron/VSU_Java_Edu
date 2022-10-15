    import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 3(20). Petrov Artem group 1.1 \n\n Посчитать количество чисел Леонардо, больших либо равных a и меньших либо равных b.\n\n";
    public static final String FIRST_BOX_TEXT = "Введите положительные целые числа (a b): ";
    public static final String SECOND_BOX_TEXT = "Сумма чисел Леонардо: ";
    public static void startProgram() {
        System.out.printf(START_TEXT);
    }
    public static void print(String text) {
        System.out.print(text);
    }

    public static final String CHANG_MEANING = "Так как вы ввели b < a, поменяем их местами \n";

    public static void printRes(int sum)
    {   print(SECOND_BOX_TEXT);
        System.out.print(sum);}


    public static void main(String[] args) {
    startProgram();
    Scanner scanner = new Scanner(System.in);
    print(FIRST_BOX_TEXT);
        Integer a = null;

        while (a == null) {
            try{
                int value = Integer.parseInt(scanner.next());
                a = value;
            }catch (Exception e) {
                System.out.println("Число 1 не подходит по формату, попробуйте снова! \n");
            }
        }
        Integer b = null;
        while (b == null) {
            try{
                int value = Integer.parseInt(scanner.next());
                b = value;
            }catch (Exception e) {
                System.out.println("Число 2 не подходит по формату, попробуйте снова! \n");
            }
        }

        if (a > b){
            int ch = b;
            b = a;
            a = ch;
            print(CHANG_MEANING);

        }

        int sum = 0;
        int k1 = 1;
        int k2 = 1;
        int k3 = 0;
        if (b <= 0){
            sum = 0;
            printRes(sum);
        }
        if (b == 1){
            sum = 2;
            printRes(sum);
        }
        else {
            if (b > 1) {
                sum = 2;
                for (int i = 0; i <= b + 2; i++) {
                    k3 = k2 + k1 + 1;
                    if (k3 >= a && k3 <= b) {
                        sum += k3;
                    }

                    k1 = k2;
                    k2 = k3;

                }
                printRes(sum);
            }
        }


    }
}