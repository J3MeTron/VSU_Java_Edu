package task3.petrov;

import javax.swing.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrameMain().setVisible(true));
        /*String str = null;
        Scanner in = new Scanner(System.in);
        int t = 0;
        while (t < 1){
            str = null;
            System.out.print("Введите строку: ");
            str = in.nextLine();
            if (PolishNotationChecker.check(str)) t++;
            else System.out.print("Введенный пример не корректен! Введите пример еще раз!\n");
        }

        //System.out.print(ReversePolishNotationMStack.evaluate(str));
        //System.out.print(ReversePolishNotation.evaluate(str));*/
    }
}