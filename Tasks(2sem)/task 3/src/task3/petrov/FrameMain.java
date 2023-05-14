package task3.petrov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain extends JFrame implements ActionListener {

    private JTextField inputField;
    private JButton checkButton;
    private JLabel resultLabel;

    public FrameMain() {
        super("Вычисление выражения в обратной польской записи");

        // Создаем компоненты
        inputField = new JTextField();
        checkButton = new JButton("Вычислить");
        checkButton.addActionListener(this);
        resultLabel = new JLabel();

        // Размещаем компоненты на панели
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        // Добавляем панель на окно
        setContentPane(panel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Получаем введенное выражение
        String expression = inputField.getText().trim();

        // Проверяем корректность выражения
        if (!PolishNotationChecker.check(expression)) {
            resultLabel.setForeground(Color.RED);
            resultLabel.setText("Некорректное выражение");
            return;
        }

        // Вычисляем значение выражения
        double result = ReversePolishNotationMStack.evaluate(expression);

        // Выводим результат
        resultLabel.setForeground(Color.BLACK);
        resultLabel.setText("Результат: " + result);
    }
}
