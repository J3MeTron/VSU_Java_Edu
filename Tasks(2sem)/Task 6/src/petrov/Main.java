package petrov;

import javax.swing.*;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.awt.Frame.MAXIMIZED_BOTH;

public class Main {
    public static void main(String[] args) {



        SwingUtilities.invokeLater(() -> {
            PriorityQueueGUI priorityQueueGUI = new PriorityQueueGUI();
            priorityQueueGUI.setVisible(true);
            priorityQueueGUI.setExtendedState(MAXIMIZED_BOTH);


            class ToDoTask {
                int priority;
                String description;
            }
            java.util.PriorityQueue<ToDoTask> q = new PriorityQueue<>(new Comparator<ToDoTask>() {
                @Override
                public int compare(ToDoTask o1, ToDoTask o2) {
                    return o1.priority - o2.priority;
                }
            });

            q.po
        });





/*        petrov.PriorityQueue<String, Integer> priorityQueue = new petrov.PriorityQueue<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить элемент");
            System.out.println("2. Получить значение с максимальным приоритетом для определенного ключа");
            System.out.println("3. Получить значение с максимальным приоритетом");
            System.out.println("4. Изменить приоритет элемента");
            System.out.println("5. Удалить элемент");
            System.out.println("6. Вывести очередь");

            System.out.print("Ваш выбор (или 'exit' для выхода): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            switch (choice) {
                case "1":
                    System.out.print("Введите ключ: ");
                    String key = scanner.nextLine();

                    System.out.print("Введите значение: ");
                    Integer value = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введите приоритет: ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    priorityQueue.enqueue(key, value, priority);
                    System.out.println("Элемент добавлен в очередь.");
                    System.out.println("------------------------------");
                    break;

                case "2":
                    System.out.print("Введите ключ: ");
                    String searchKey = scanner.nextLine();

                    Integer minValue = priorityQueue.dequeueMinPriorityWithKey(searchKey);
                    if (minValue != null) {
                        System.out.println("Значение с минимальным приоритетом для ключа " + searchKey + ": " + minValue);
                    } else {
                        System.out.println("Нет элементов с заданным ключом.");
                    }
                    System.out.println("------------------------------");
                    break;


                case "3":
                    Integer minPriorityValue = priorityQueue.dequeueMinPriority();
                    String minPriorityKey = priorityQueue.dequeueMinPriorityKey();
                    if (minPriorityValue != null) {
                        System.out.println("Значение с минимальным приоритетом: Key: " + minPriorityKey + ", Value: " + minPriorityValue);
                    } else {
                        System.out.println("Очередь пуста.");
                    }
                    System.out.println("------------------------------");
                    break;

                case "4":
                    System.out.print("Введите ключ элемента, для которого нужно изменить приоритет: ");
                    String changeKey = scanner.nextLine();

                    System.out.print("Введите значение: ");
                    value = Integer.parseInt(scanner.nextLine());

                    System.out.print("Введите новый приоритет: ");
                    int newPriority = Integer.parseInt(scanner.nextLine());

                    priorityQueue.changePriority(changeKey, newPriority, value);
                    System.out.println("Приоритет элемента изменен.");
                    System.out.println("------------------------------");
                    break;

                case "5":
                    System.out.print("Введите ключ элемента, который нужно удалить: ");
                    String removeKey = scanner.nextLine();
                    System.out.print("Введите значение: ");
                    value = Integer.parseInt(scanner.nextLine());

                    priorityQueue.remove(value, removeKey);
                    System.out.println("Элемент удален из очереди.");
                    System.out.println("------------------------------");
                    break;

                case "6":
                    System.out.println("------------------------------");
                    priorityQueue.printQueue();
                    System.out.println("------------------------------");

                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }*/
    }
}
