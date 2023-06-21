package petrov;

import java.util.Map;
import java.util.TreeMap;

public class PriorityQueue<K, V> {
    private TreeMap<Integer, Map<K, V>> queue;
    private int priority;

    public PriorityQueue() {
        queue = new TreeMap<>();
        priority = 0;
    }

    public void enqueue(K key, V value, int priority) {
        Map<K, V> items = queue.getOrDefault(priority, new TreeMap<>());
        items.put(key, value);
        queue.put(priority, items);
    }

    public V dequeueMinPriorityWithKey (K key) {
        for (Map.Entry<Integer, Map<K, V>> entry : queue.entrySet()) {
            Map<K, V> items = entry.getValue();
            if (items.containsKey(key)) {
                return items.get(key);
            }
        }
        return null;
    }
    public V dequeueMinPriority() {
        Map<K, V> items = queue.firstEntry().getValue();
        Map.Entry<K, V> minEntry = items.entrySet().iterator().next();
        if (items.isEmpty()) {
            queue.pollFirstEntry();
        }
        return minEntry.getValue();
    }
    public K dequeueMinPriorityKey() {
        Map<K, V> items = queue.firstEntry().getValue();
        Map.Entry<K, V> minEntry = items.entrySet().iterator().next();
        if (items.isEmpty()) {
            queue.pollFirstEntry();
        }
        return minEntry.getKey();
    }

    public void changePriority(K key, int newPriority, V value) {
        V valuen = removeByKey(value,key);
        if (valuen != null) {
            enqueue(key, value, newPriority);
        }
    }

    public void remove(V vaule,K key) {
        removeByKey(vaule, key);
    }


    public void printQueue() {
        for (Map.Entry<Integer, Map<K, V>> entry : queue.entrySet()) {
            int priority = entry.getKey();
            Map<K, V> items = entry.getValue();
            System.out.println("Priority: " + priority);
            for (Map.Entry<K, V> itemEntry : items.entrySet()) {
                System.out.println("Key: " + itemEntry.getKey() + ", Value: " + itemEntry.getValue());
            }
        }
    }

    private V removeByKey( V value, K key) {
        for (Map.Entry<Integer, Map<K, V>> entry : queue.entrySet()) {
            Map<K, V> items = entry.getValue();
            if (items.containsKey(key) && items.containsValue(value)) {
                V valuev = items.remove(key);
                if (items.isEmpty()) {
                    queue.remove(entry.getKey());
                }
                return valuev;
            }
        }
        return null;
    }
    public String getQueue() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Map<K, V>> entry : queue.entrySet()) {
            int priority = entry.getKey();
            Map<K, V> items = entry.getValue();
            sb.append("Priority: ").append(priority).append("\n");
            for (Map.Entry<K, V> itemEntry : items.entrySet()) {
                K key = itemEntry.getKey();
                V value = itemEntry.getValue();
                sb.append("Key: ").append(key).append(", Value: ").append(value).append("\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
