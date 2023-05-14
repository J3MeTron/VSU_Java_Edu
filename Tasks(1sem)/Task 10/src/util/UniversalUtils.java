package util;

import java.util.Scanner;

public class UniversalUtils {

    public static void print(String text) {
        System.out.print(text);
    }

    public static int readIntegerValueOfChooseFromConsole() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String value = scanner.nextLine();
            try {
                int res = Integer.parseInt(value);
                return res;
            } catch (Exception e) {
                System.out.printf(" -> неверное значение (%s)%n", value);
            }
        }
    }
}

