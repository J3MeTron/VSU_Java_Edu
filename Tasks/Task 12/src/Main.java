import util.UniversalUtils;

public class Main {

    public static final String START_TEXT = "Task 12(15). Petrov Artem group 1.1 Напишите рекурсивную программу генерации всех правильных скобочных структур длины 2n. Для размещений\n\n";

    public static void startProgram() {
        UniversalUtils.print(START_TEXT);
    }

    public static void main(String[] args) {
        startProgram();
        UniversalUtils.print("Введите целое положительное число n: ");
        int n = UniversalUtils.readPositiveIntegerValueOfChooseFromConsole();
        UniversalUtils.print("\n");
        char[] charBox = new char[2 * n];
        printParenthesis(charBox, 0, n, 0, 0);
    }

    static void printParenthesis(char[] str, int pos, int n, int open, int close) {
        if (close == n) {
            for (char c : str) System.out.print(c);
            System.out.println();
            return;
        } else {
            if (open > close) {
                str[pos] = ')';
                printParenthesis(str, pos + 1, n, open, close + 1);
            }
            if (open < n) {
                str[pos] = '(';
                printParenthesis(str, pos + 1, n, open + 1, close);
            }
        }
    }
}