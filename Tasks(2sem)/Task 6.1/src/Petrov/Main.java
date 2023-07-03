package Petrov;

import javax.swing.*;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ToDoListApp app = new ToDoListApp();
            }
        });

    }
}
