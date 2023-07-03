package Petrov;
import java.util.ArrayList;
import java.util.List;

public class PriorityQueueTree<T extends Comparable<T>> {
    private Node root;
    private int size;

    private class Node {
        T data;
        Node parent;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

    public PriorityQueueTree() {
        root = null;
        size = 0;
    }

    public void add(T item) {
        Node newNode = new Node(item);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            while (true) {
                if (item.compareTo(current.data) < 0) {
                    if (current.left == null) {
                        current.left = newNode;
                        newNode.parent = current;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        newNode.parent = current;
                        break;
                    }
                    current = current.right;
                }
            }
            // Restore heap property
            while (newNode.parent != null && newNode.data.compareTo(newNode.parent.data) < 0) {
                swapData(newNode, newNode.parent);
                newNode = newNode.parent;
            }
        }
        size++;
    }

    public T poll() {
        if (root == null) {
            return null;
        }
        T item = root.data;
        if (size == 1) {
            root = null;
        } else {
            Node lastNode = removeLastNode();
            root.data = lastNode.data;
            // Restore heap property
            Node current = root;
            while (true) {
                Node smallestChild = current;
                if (current.left != null && current.left.data.compareTo(smallestChild.data) < 0) {
                    smallestChild = current.left;
                }
                if (current.right != null && current.right.data.compareTo(smallestChild.data) < 0) {
                    smallestChild = current.right;
                }
                if (smallestChild == current) {
                    break;
                }
                swapData(current, smallestChild);
                current = smallestChild;
            }
        }
        size--;
        return item;
    }

    public T peek() {
        return (root != null) ? root.data : null;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    private Node removeLastNode() {
        Node lastNode = null;
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            lastNode = queue.remove(0);
            if (lastNode.left != null) {
                queue.add(lastNode.left);
            }
            if (lastNode.right != null) {
                queue.add(lastNode.right);
            }
        }
        if (lastNode.parent.left == lastNode) {
            lastNode.parent.left = null;
        } else {
            lastNode.parent.right = null;
        }
        lastNode.parent = null;
        return lastNode;
    }

    private void swapData(Node node1, Node node2) {
        T temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }
}
