import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 7(10). Petrov Artem group 1.1 \n\nВводится массив целых чисел. \n" +
            "Найти максимальную сумму подряд идущих элементов. \n" +
            "Примечание: существует алгоритм, как можно получить такую сумму в один проход — постарайтесь догадаться.\n\n";

    public static void startProgram() {
        System.out.printf(START_TEXT);
    }

    public static void print(String text) {
        System.out.print(text);
    }

    public static void consoleInputOutputArray2() {
        // ввод массива
        int[] arr = ArrayUtils.readIntArrayFromConsole();

        // обработка массива
        int sum = 0;
        int max = 0;
        int sumA = 0;
        int answ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0){
                sum += arr[i];
            }
            else{
                if ((sum+arr[i]) > 0 ){
                    sum += arr[i];
                }
                else{
                    sum = 0;
                }
            }
            if (sum > max){
                max = sum;
            }
        }



        answ =sum >max ?sum :max;

        // вывод массива
        System.out.printf("\"Обработанный\" массив:%n%s%n",ArrayUtils.toString(arr));

        print("Максимальная сумма: ");
        System.out.print(answ);

    }

    public static void main(String[] args) {
        startProgram();
        consoleInputOutputArray2();

    }
}