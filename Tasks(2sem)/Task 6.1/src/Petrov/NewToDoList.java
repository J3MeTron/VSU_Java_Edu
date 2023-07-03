package Petrov;

import java.util.Comparator;
import java.util.Iterator;

public class NewToDoList implements Iterable<ToDoItem> {
    private MyPQ<ToDoItem> tasks;
    public NewToDoList(){
        tasks = new MyPQ<>(new Comparator<ToDoItem>() {
            @Override
            public int compare(ToDoItem o1, ToDoItem o2) {
                if(o1.getPriority().length() < o2.getPriority().length()){
                    return -1;
                } else if(o1.getPriority().length() > o2.getPriority().length()){
                    return 1;
                } else if(o1.getPriority().length() == o2.getPriority().length()){
                    if (getPriorityLevel(o1.getPriority()) < getPriorityLevel(o2.getPriority())){
                        return -1;
                    } else if (getPriorityLevel(o1.getPriority()) > getPriorityLevel(o2.getPriority())){
                        return 1;
                    }
                    return 0;
                }
                return 0;
            }
        });
    }

    public void addTask(ToDoItem task) {
        tasks.add(task);
    }

    public void remove(ToDoItem task){
        tasks.removeTask(task);
    }

    public ToDoItem removeNextTask(){
        return tasks.remove();
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

    @Override
    public Iterator<ToDoItem> iterator() {
        return tasks.iterator();
    }
}
