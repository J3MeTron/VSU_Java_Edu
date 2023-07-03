package Petrov;

public class ToDoItem {
    private String priority;
    private String description;

    public ToDoItem(String priority, String description) {
        this.priority = priority;
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return getPriority() + " - " + getDescription();
    }
}
