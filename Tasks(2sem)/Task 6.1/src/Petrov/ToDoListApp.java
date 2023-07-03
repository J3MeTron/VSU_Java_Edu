package Petrov;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ToDoListApp extends JFrame {
    private JList<ToDoItem> taskList;
    private DefaultListModel<ToDoItem> listModel;

    private JButton addButton;
    private JButton removeButton;
    private JButton removeNextTaskButton;
    private JTextField priorityField;
    private JTextField descriptionField;

    private NewToDoList toDo = new NewToDoList();

    public ToDoListApp() {
        setTitle("Приложение ToDoList");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        priorityField = new JTextField(5);
        descriptionField = new JTextField(20);
        addButton = new JButton("Добавить задачу");
        removeButton = new JButton("Удалить задачу");
        removeNextTaskButton = new JButton("Следующая задача");


        inputPanel.add(new JLabel("Приоритет: "));
        inputPanel.add(priorityField);
        inputPanel.add(new JLabel("Описание: "));
        inputPanel.add(descriptionField);
        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(removeNextTaskButton);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String priorityText = priorityField.getText();
                String description = descriptionField.getText();
                try {
                    ToDoItem t = new ToDoItem(priorityText, description);
                    toDo.addTask(t);
                    updateTaskList();
                    clearInputFields();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(ToDoListApp.this,
                            "Некорректный приоритет! Пожалуйста, введите заглавную латинскую букву, цифру или их сочетание.",
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    ToDoItem task = listModel.get(selectedIndex);
                    toDo.remove(task);
                    updateTaskList();
                }
            }
        });
        removeNextTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ToDoListApp.this,"Следующая задача: " + toDo.removeNextTask());
                updateTaskList();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void updateTaskList() {
        listModel.clear();
        for (ToDoItem task : toDo) {
            String taskInfo = task.getPriority() + " - " + task.getDescription();
            listModel.addElement(task);
        }
    }

    private void clearInputFields() {
        priorityField.setText("");
        descriptionField.setText("");
        priorityField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp();
            }
        });
    }
}
