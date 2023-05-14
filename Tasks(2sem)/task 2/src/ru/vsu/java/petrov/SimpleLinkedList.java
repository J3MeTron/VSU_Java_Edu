package ru.vsu.java.petrov;

import java.util.Comparator;
import java.util.Iterator;


public class SimpleLinkedList<T> implements Iterable<T> {

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode<T> {
        private T value;
        public SimpleLinkedListNode<T> next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode<T> head = null;
    private SimpleLinkedListNode<T> tail = null;
    private int count = 0;

    public void addFirst(T value) {
        head = new SimpleLinkedListNode<>(value, head);
        if (count == 0) {
            tail = head;
        }
        count++;
    }

    public void addLast(T value) {
        SimpleLinkedListNode<T> temp = new SimpleLinkedListNode<>(value);
        if (count == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        count++;
    }

    private void checkEmpty() throws SimpleLinkedListException {
        if (count == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedListNode<T> getNode(int index) {
        int i = 0;
        for (SimpleLinkedListNode<T> curr = head; curr != null; curr = curr.next, i++) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }

    public T removeFirst() throws SimpleLinkedListException {
        checkEmpty();

        T value = head.value;
        head = head.next;
        if (count == 1) {
            tail = null;
        }
        count--;
        return value;
    }

    public T removeLast() throws SimpleLinkedListException {
//        checkEmpty();
//
//        T value = tail.value;
//        if (count == 1) {
//            head = tail = null;
//        } else {
//            SimpleLinkedListNode<T> prev = getNode(count - 2);
//            prev.next = null;
//            tail = prev;
//        }
//        count--;
//        return value;
        return remove(count - 1);
    }

    public T remove(int index) throws SimpleLinkedListException {
        checkEmpty();
        if (index < 0 || index >= count) {
            throw new SimpleLinkedListException("Incorrect index");
        }

        T value;
        if (index == 0) {
            value = head.value;
            head = head.next;
        } else {
            SimpleLinkedListNode<T> prev = getNode(index - 1);
            SimpleLinkedListNode<T> curr = prev.next;
            value = curr.value;
            prev.next = curr.next;
            if (index == count - 1) {
                tail = prev;
            }
        }
        count--;
        return value;
    }

    public static int[] SimpleLinkedListToArray(SimpleLinkedList list) throws SimpleLinkedListException {
        int[] array = new int[list.count];
        for (int i = 0; i < list.count; i++) array[i] = (int) list.get(i);
        return array;
    }

    public void insert(int index, T value) throws SimpleLinkedListException {
        if (index < 0 || index > count) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            addFirst(value);
        } else {
            SimpleLinkedListNode<T> prev = getNode(index - 1);
            prev.next = new SimpleLinkedListNode<>(value, prev.next);
            if (index == count) {
                tail = prev.next;
            }
        }
        count++;
    }

    public int size() {
        return count;
    }

    public T getFirst() throws SimpleLinkedListException {
        checkEmpty();
        return head.value;
    }

    public T getLast() throws SimpleLinkedListException {
        checkEmpty();
        return tail.value;
    }

    public T get(int index) throws SimpleLinkedListException {
        if (index < 0 || index >= count) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        return getNode(index).value;
    }


    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode<T> curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }


        return new SimpleLinkedListIterator();
    }


    public void swapMinMax(SimpleLinkedList<Integer> list) throws SimpleLinkedListException {
        int min = list.get(0);
        int max = list.get(0);
        int i = 0;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> minCon = list.head;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> maxCon = list.head;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> maxConD = null;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> minConD = null;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> next = list.head;
        while (i < list.count - 1) {
            if (min > next.next.value) {
                minCon = next;
                min = next.next.value;
            }
            if (max < next.next.value) {
                maxCon = next;
                max = next.next.value;

            }
            if (i == (list.count - 2)) {
                next = list.tail;
            } else {
                next = next.next;
            }
            i++;
        }

        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> maxConDD;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> maxConDDN;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> minConDD;
        SimpleLinkedList<Integer>.SimpleLinkedListNode<Integer> minConDDN;

        if (minCon != list.head && maxCon != list.head && minCon != list.tail && maxCon != list.tail && maxCon.next != minCon && minCon.next != maxCon) {
            maxConDD = maxCon.next;
            maxConDDN = maxCon.next.next;
            maxCon.next = minCon.next;
            maxConDD.next = maxCon.next.next;
            minCon.next = maxConDD;
            maxCon.next.next = maxConDDN;
        } else if (maxCon.next == minCon && maxCon == list.head) {
            maxConD = maxCon.next;
            maxCon.next = minCon.next;
            minCon.next = maxConD;

        } else if (maxCon.next == minCon && minCon.next == list.tail) {
            maxConDD = maxCon.next;
            maxCon.next = maxCon.next.next;
            maxConDD.next = maxCon.next.next;
            maxCon.next.next = maxConDD;

        } else if (minCon.next == maxCon && minCon == list.head) {
            maxConDD = maxCon.next;
            maxCon.next = maxCon.next.next;
            maxConDD.next = maxCon.next.next;
            maxCon.next.next = maxConDD;

        } else if (minCon.next == minCon && maxCon.next == list.tail) {
            maxConDD = maxCon.next;
            maxCon.next = maxCon.next.next;
            maxConDD.next = maxCon.next.next;
            maxCon.next.next = maxConDD;

        } else if (maxCon.next == minCon && maxCon != list.head && minCon != list.tail) {
            maxConDD = maxCon.next;
            maxCon.next = maxCon.next.next;
            maxConDD.next = maxCon.next.next;
            maxCon.next.next = maxConDD;

        } else if (minCon.next == maxCon && minCon != list.head && maxCon != list.tail) {
            minConDD = minCon.next;
            minCon.next = minCon.next.next;
            minConDD.next = minCon.next.next;
            minCon.next.next = minConDD;

        } else if (maxCon == list.head && minCon != list.tail) {
            maxConDD = maxCon;
            maxConDDN = maxCon.next;
            list.head = minCon.next;
            maxConDD.next = minCon.next.next;
            minCon.next = maxConDD;
            list.head.next = maxConDDN;

        } else if (minCon == list.head && maxCon != list.tail) {
            minConDD = minCon;
            minConDDN = minCon.next;
            list.head = maxCon.next;
            minConDD.next = maxCon.next.next;
            maxCon.next = minConDD;
            list.head.next = minConDDN;

        } else if (minCon == list.head && maxCon == list.tail) {
            minConDD = minCon;
            list.head = maxCon;
            list.tail = minCon;
            list.head.next = minConDD;

        } else if (maxCon == list.head && minCon == list.tail) {
            maxConDD = maxCon;
            list.head = minCon;
            list.tail = maxCon;
            list.head.next = maxConDD;
        }
    }

    public void swapMinMax2(Comparator<T> comparator) throws SimpleLinkedListException {
        T min = head.value;
        T max = head.value;
        SimpleLinkedListNode<T> prevHead = new SimpleLinkedListNode<>(null);
        prevHead.next = head;
        SimpleLinkedListNode<T> minCon = prevHead;
        SimpleLinkedListNode<T> maxCon = prevHead;
        SimpleLinkedListNode<T> next = head;
        while (next.next != null) {
            if (comparator.compare(min, next.next.value) > 0) {
                minCon = next;
                min = next.next.value;
            }
            if (comparator.compare(max, next.next.value) < 0) {
                maxCon = next;
                max = next.next.value;

            }
            next = next.next;
        }


        if (maxCon.next == minCon) {
            SimpleLinkedListNode<T> tmp = maxCon;
            maxCon = minCon;
            minCon = tmp;
        }

        SimpleLinkedListNode<T> a, b, c, x, y, z;
        a = minCon;
        b = a.next;
        c = b.next;

        x = maxCon;
        y = x.next;
        z = y.next;


        if (minCon.next == maxCon) {
            a.next = y;
            y.next = b;
            b.next = z;
        } else {

            //b <-> y
            a.next = y;
            y.next = c;

            x.next = b;
            b.next = z;
        }

        if (b == head)
            head = y;
        else if (y == head)
            head = b;

        if (b == tail)
            tail = y;
        else if (y == tail)
            tail = b;

        /*if (maxCon == prevHead){
            maxCon = head;
        }
        if (minCon == prevHead){
            minCon = head;
        }*/

        /*SimpleLinkedListNode<T> node1 = null;
        SimpleLinkedListNode<T> node2 = null;
        next = head;
        while (next.next != null) {
            if (next == maxCon) {
                if (node1 == null) {
                    node1 = maxCon;
                    node2 = minCon;
                }
            } else if (next == minCon) {
                if (node1 == null) {
                    node1 = minCon;
                    node2 = maxCon;
                }
            }
            next = next.next;
        }
        SimpleLinkedListNode<T> temp;
        SimpleLinkedListNode<T> temp2;


        if (node1 != head && node2 != tail && node1.next == node2) {
            temp = node1.next;
            node1.next = node1.next.next;
            temp.next = node1.next.next;
            node1.next.next = temp;
        }else if (node1 != head && node2 != tail) {
            temp = node1.next;
            temp2 = node1.next.next;
            node1.next = node2.next;
            temp.next = node1.next.next;
            node2.next = temp;
            node1.next.next = temp2;
        }
        else if(node1 == head && node2 != tail && node1.next != node2.next){
            temp = node1;
            temp2 = node1.next;
            head = node2.next;
            temp.next = node1.next;
            node2.next = temp;
            head.next = temp2;
        }*/
    }
}


