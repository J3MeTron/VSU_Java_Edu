import java.util.Scanner;

public class Main {
    public static final String START_TEXT = "Task 4(21). \n\n Найти сумму 1^k + 2^k + 3^k + 4^k + .. + N^k \n\n";

    public static final String FIRST_BOX_TEXT = "Введите положительные целое число (N): ";

    public static final String SECOND_BOX_TEXT = "Введите положительные целое число (k): ";

    public static final String THIRD_BOX_TEXT = "Сумма 1^k + 2^k + 3^k + 4^k + .. + N^k: ";

    static int readIntegerValueFromConsole(){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            try {
                int res = Integer.parseInt(value);
                if (res <= 0) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", value);
            }
        }
    }

    public static void startProgram() {

        System.out.printf(START_TEXT);
        print(FIRST_BOX_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    static double sumOfProgression(int N, int k){
        double sum = 0;
        for (int i = 1; i < N + 1; i++ ){
            sum += Math.pow(i,k);
        };
        return sum;
    };

    public static void main(String[] args) {
        startProgram();
        int N = readIntegerValueFromConsole();

        print(SECOND_BOX_TEXT);
        int k = readIntegerValueFromConsole();

        double sum = sumOfProgression( N, k);

        print(THIRD_BOX_TEXT);
        System.out.printf("%.0f", sum);


    }
}