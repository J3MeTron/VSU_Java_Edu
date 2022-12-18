package ru.vsu.cs.course1;

import java.util.Objects;


// Класс должен реализовывать интерфейс Comparable<T>, если необходимо
// использовать класс Point в качестве ключей в TreeSet или TreeMap
public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Point() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    // методы должны быть добавлены и корректно реализованы, если необходимо
    // использовать класс Point в качестве ключей в HashSet или HashMap
    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Point)) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        // return x * 31 + y;
        return Objects.hash(x, y);
    }

    // метод должны быть добавлен и корректно реализован, если необходимо
    // использовать класс Point в качестве ключей в TreeSet или TreeMap
    // (это метод Comparable<T>)
    @Override
    public int compareTo(Point o) {
        return (x - o.x == 0) ? (y - o.y) : (x - o.x);
    }
}
