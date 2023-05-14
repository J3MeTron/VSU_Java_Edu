package task3.petrov;

import java.util.ArrayList;
import java.util.LinkedList;

public class mStack<T> {

    private static class Node<T> {
        public T value;
        public Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node<T> head = null;
    private int size = 0;

    public void push(T item) {
        Node<T> x = new Node<T>(item,head);
        head = x;
        size++;
    }

    public T pop() throws SimpleLinkedList.SimpleLinkedListException { //извлекается из конца списка и возвращается
        if (isEmpty()) {
            return null;
        }

        T item = head.value;
        head = head.next;
        size--;
        return item;
    }

    public T peek() throws SimpleLinkedList.SimpleLinkedListException { //возвращает элемент на вершине стека без его извлечения
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }
}
