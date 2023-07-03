package Petrov;

import java.util.*;

public class MyPQ<T> implements Iterable<T> {

    private TreeMap<T, List<T>> tasks;
    public MyPQ(Comparator<T> cmp) {
        tasks = new TreeMap<>(cmp);
    }
    public void add(T item) {
        T priority = item;
        List<T> items = tasks.getOrDefault(priority, new ArrayList<>());
        items.add(item);
        tasks.put(priority, items);
    }

    public void removeTask(ToDoItem task){
        if (tasks.isEmpty()) {
            return;
        }

        List<T> items = tasks.get(task);
        T item = items.remove(items.size() - 1);

        if (items.isEmpty()) {
            tasks.remove(task);
        }
    }
    public T remove() {
        if (tasks.isEmpty()) {
            return null;
        }

        T priority = tasks.firstKey();
        List<T> items = tasks.get(priority);
        T item = items.remove(items.size() - 1);

        if (items.isEmpty()) {
            tasks.remove(priority);
        }

        return item;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }


    @Override
    public Iterator<T> iterator() {
        Iterator<T> itr = tasks.keySet().iterator();
        return new Iterator<T>() {
            List<T> current = new ArrayList<>();
            int index = 0;

            @Override
            public boolean hasNext() {
                return itr.hasNext() || index+1 < current.size();
            }

            @Override
            public T next() {
                if (index+1 < current.size()){
                    index++;
                    return current.get(index);
                } else {
                    current = tasks.get(itr.next());
                    index = 0;
                    return current.get(index);
                }
            }
        };
    }
}
