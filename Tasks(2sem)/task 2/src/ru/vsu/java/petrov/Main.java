package ru.vsu.java.petrov;

import util.SwingUtils;

import java.util.*;

public class Main {
    public static final String START_TEXT = "Task 2(21). Petrov Artem group 1.1 \n\n21. В списке целых чисел поменять местами первый элемент, содержащий наименьшее\n" +
            "значение, с последним элементом, содержащим наибольшее значение. Обратите\n" +
            "внимание: менять значение (Value) в элементах списка запрещено, необходимо именно\n" +
            "переставить элементы. Допускается не более одного прохода по списку.\n\n";

    public static void startProgram() {
        util.UniversalUtils.print(START_TEXT);
    }

    static int readIntegerValueFromConsole() {
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

    public static SimpleLinkedList<Integer> ArrayToSimpleLinkedList(int[] arr) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.addLast(arr[i]);
        }
        return list;
    }


    public static void winMain() throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }

    public static void main(String[] args) throws Exception {
        startProgram();
        winMain();

    }
}