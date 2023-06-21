package petrov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PriorityQueueGUI extends JFrame {
    private PriorityQueue<String, Integer> priorityQueue;
    private JTextArea outputTextArea;
    private JTextField keyTextField;
    private JTextField valueTextField;
    private JTextField priorityTextField;

    public PriorityQueueGUI() {
        priorityQueue = new PriorityQueue<>();
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Приоритетная очередь");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputTextArea);

        JLabel keyLabel = new JLabel("Ключ:");
        JLabel valueLabel = new JLabel("Значение:");
        JLabel priorityLabel = new JLabel("Приоритет:");

        keyTextField = new JTextField(10);
        valueTextField = new JTextField(10);
        priorityTextField = new JTextField(10);

        JButton addButton = new JButton("Добавить");
        JButton getMinValueButton = new JButton("Получить мин. значение");
        JButton changePriorityButton = new JButton("Изменить приоритет");
        JButton removeButton = new JButton("Удалить элемент");
        JButton helpButton = new JButton("Помощь");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyTextField.getText();
                int value = Integer.parseInt(valueTextField.getText());
                int priority = Integer.parseInt(priorityTextField.getText());
                priorityQueue.enqueue(key, value, priority);
                updateOutputTextArea();
            }
        });

        getMinValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyTextField.getText();
                Integer minValue = key.isEmpty() ? priorityQueue.dequeueMinPriority() : priorityQueue.dequeueMinPriorityWithKey(key);
                if (key == null){key = priorityQueue.dequeueMinPriorityKey();}
                if (minValue != null) {
                    JOptionPane.showMessageDialog(PriorityQueueGUI.this, "Значение с минимальным приоритетом для ключа " + key + " : " + minValue);
                    updateOutputTextArea();
                } else {
                    JOptionPane.showMessageDialog(PriorityQueueGUI.this, "Список пуст!");
                }
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(PriorityQueueGUI.this,"Добавить: должны быть заполнены все поля! " +
                        "\nПолучить мин. значение: введите ключ для которого искать значение с минимальным приоритетом или оставьте поле пустым, тогда выведется первое значение с минимальным приоритетом \n" +
                        "Изменить приоритет: Введите ключ, значение и новый приоритет в поле приоритет" +
                        "\nУдалить элемент: введите ключ и значение");
            }
        });

        changePriorityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyTextField.getText();
                int value = Integer.parseInt(valueTextField.getText());
                int newPriority = Integer.parseInt(priorityTextField.getText());
                priorityQueue.changePriority(key, newPriority, value);
                updateOutputTextArea();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyTextField.getText();
                int value = Integer.parseInt(valueTextField.getText());
                priorityQueue.remove(value, key);
                updateOutputTextArea();
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(5, 2, 10, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        controlPanel.add(keyLabel);
        controlPanel.add(keyTextField);
        controlPanel.add(valueLabel);
        controlPanel.add(valueTextField);
        controlPanel.add(priorityLabel);
        controlPanel.add(priorityTextField);
        controlPanel.add(addButton);
        controlPanel.add(getMinValueButton);
        controlPanel.add(changePriorityButton);
        controlPanel.add(removeButton);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(controlPanel, BorderLayout.SOUTH);
        contentPane.add(helpButton, BorderLayout.NORTH);
    }

    private void updateOutputTextArea() {
        String queueString = priorityQueue.getQueue();

        outputTextArea.setText(queueString);
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PriorityQueueGUI().setVisible(true);
            }
        });
    }
}
