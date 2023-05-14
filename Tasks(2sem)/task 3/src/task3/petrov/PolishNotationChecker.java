package task3.petrov;


import java.util.Stack;

public class PolishNotationChecker {
    public static boolean check(String expression) {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split(" "); //разбиваем на подстроки

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    return false; // не хватает операндов для выполнения операции
                }
                stack.pop();
                stack.pop();
                stack.push("result"); // результат операции заменяет два операнда в стеке
            } else {
                if (!isNumber(token)) {
                    return false; // некорректный токен (не число и не оператор)
                }
                stack.push(token);
            }
        }

        return stack.size() == 1 && stack.peek().equals("result"); // выражение корректно, если в стеке остался только результат
    }

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"); //сравнение строк (проверка на конкретный знак)
    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
