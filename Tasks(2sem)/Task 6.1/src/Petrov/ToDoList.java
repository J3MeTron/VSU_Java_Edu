package Petrov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList implements Comparable<ToDoList> {
    private String priority;
    private String description;

    private static List<ToDoList> taskList = new ArrayList<>();

    public ToDoList(String priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public static void addTask(ToDoList task) {
        taskList.add(task);
    }

    public static List<ToDoList> getAllTasks() {
        List<ToDoList> sortedTasks = new ArrayList<>(taskList);
        Collections.sort(sortedTasks);
        return sortedTasks;
    }

    public static ToDoList getHighestPriorityTask() {
        if (taskList.isEmpty()) {
            return null;
        }
        ToDoList highestPriorityTask = taskList.get(0);
        for (ToDoList task : taskList) {
            if (isHigherPriority(task.getPriority(), highestPriorityTask.getPriority())) {
                highestPriorityTask = task;
            }
        }
        return highestPriorityTask;
    }

    public static void removeTask(ToDoList task) {
        taskList.remove(task);
    }

    @Override
    public int compareTo(ToDoList other) {
        return this.priority.compareTo(other.getPriority());
    }

    private static boolean isHigherPriority(String priority1, String priority2) {
        int level1 = getPriorityLevel(priority1);
        int level2 = getPriorityLevel(priority2);

        if (level1 != level2) {
            return level1 < level2;
        } else {
            return priority1.compareTo(priority2) < 0;
        }
    }

    private static int getPriorityLevel(String priority) {
        if (priority.matches("[A-Z]")) {
            return 1;
        } else if (priority.matches("[A-Z][0-9]+")) {
            return 2;
        } else if (priority.matches("[0-9]+")) {
            return 3;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
