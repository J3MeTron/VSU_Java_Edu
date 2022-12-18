package ru.vsu.cs.course1;

import java.util.*;


/*
   List<T> - похож на массив,
             но позволяет добавлять, удалять элементы
     реализации:
       ArrayList<T> - используется чаще всего
       LinkedList<T>
   ----------------------------------------------------------
   Set<T> - множество
              - добавить элемент
              - удалить элемент
              - проверить наличие
     реализации:
       HashSet<Е>
       TreeSet<T>
       и др.
   ----------------------------------------------------------
   Map<K, V> - словарь (сопоставление значения ключу)
                 { key -> value }
              - добавить значение по ключу
              - удалить значение по ключу
              - прочитать значение по ключу
              - проверить наличие ключа
     реализации:
       HashMap<Е>
       TreeMap<T>
       и др.
   ----------------------------------------------------------
   Stack<T> - стек
              - положить в стек
              - взять из стека
     реализации:
       Stack<T> и есть реализация (не совсем грамотно, не выделен интерфейс)
   ----------------------------------------------------------
   Queue<T> - очередь
              - положить в очередь
              - взять из очереди
     реализации:
        ArrayDeque<T>
        LinkedList<T>
        PriorityQueue<T>
        и еще несколько классов для различных задач в многопоточных приложениях
   ----------------------------------------------------------
   Deque<E> - функциональность и очереди и стека одновременно
              (можно добавлять/забирать элементы как в/из начала, так и конца очереди)
     реализации:
       ArrayDeque<Е>
       LinkedList<T>
       и др.
 */
public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        System.out.println("--------- Работа со списками -----------");
            listDemo(new ArrayList<>());
        listDemo(new LinkedList<>());
        System.out.println("----------------------------------------");

        System.out.println("--------- Работа с множествами ---------");
        List<Integer> list = Arrays.asList(1, 3, 2, 4, 3, 2, 333, 333, 3, 1000, 5);
        list = uniqValues(list);
        printCollection(list);
        System.out.println("----------------------------------------");

        System.out.println("--------- Работа со словарями ----------");
        mapDemo();
        System.out.println("----------------------------------------");

        System.out.println("--- Работа со вложенными структурами ---");
        nestedCollectionsDemo1();
        System.out.println("----------------------------------------");
        nestedCollectionsDemo2();
        System.out.println("----------------------------------------");

        System.out.println("------ Особенности классов-ключей ------");
        pointClassDemo();
        System.out.println("----------------------------------------");

        System.out.println("--------- Работа с очередями -----------");
        queueDemo();
        System.out.println("----------------------------------------");

        System.out.println("--------- Работа со стеками ------------");
        stackDemo();
        System.out.println("----------------------------------------");
    }


    public static <T> void printCollection(Collection<T> collection) {
        boolean first = true;
        for (T item : collection) {
            System.out.print((first ? "" : ", ") + item);
            first = false;
        }
        System.out.println();
    }

    // неэффективная применительно к LinkedList реализация, т.к. есть обращение по индексу
    public static Integer maxValue1(List<Integer> list) {
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // реализация эффективна для любой реализации списка
    public static Integer maxValue2(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static <K, V> void printMap(Map<K, V> map) {
        // в новых версиях Java можно написать через var
        //   for (var kv : map.entrySet()) { ... }
        for (Map.Entry<K, V> kv : map.entrySet()) {
            System.out.printf("%s -> %s%n", kv.getKey(), kv.getValue());
        }

        /*
        // перебор ключей, но если нужны именно пары (ключ -> значение), лучше перебирать по entrySet()
        for (K key : marks.keySet()) {
            V value = marks.get(key);
        }
        */
    }


    public static void listDemo(List<Integer> numbers) {
        numbers.clear();

        Scanner scan = new Scanner(System.in);
        System.out.println("Вводим целые числа (окончание - отрицательное число):");
        while (true) {
            System.out.print("> ");
            int num = scan.nextInt();
            if (num < 0) {
                break;
            }
            numbers.add(num);
        }
        for (int i = 0; i < numbers.size(); i++) {
            //          массив:       список:
            // чтение:   arr[i]        list.get(i)
            // запись:   arr[i] = v    list.set(i, v)
            //
            // numbers[i]++;
            // numbers[i] = numbers[i] + 1;
            numbers.set(i, numbers.get(i) + 1);
        }
        if (numbers.size() > 1) {
            numbers.remove(1);
        }
        printCollection(numbers);
    }


    public static List<Integer> uniqValues(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> uniq = new HashSet<>();
        for (Integer v : list) {
            if (!uniq.contains(v)) {
                result.add(v);
                uniq.add(v);
            }
        }
        return result;
    }


    public static List<Integer> uniqValues2(List<Integer> list) {
        // в данной реализации порядок встречаемости уникальных элементов будет нарушен

        Set<Integer> uniq = new HashSet<>(list);
        // Set<Integer> uniq = new TreeSet<>();
        return new ArrayList<>(uniq);
    }


    public static void mapDemo() {
        // Map<String, Integer> map = new TreeMap<>();
        Map<String, Integer> marks = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("Вводим студентов с оценками (окончание - \"-\" в качестве фамилии):");
        while (true) {
            System.out.print("имя: ");
            String name = scan.next();
            if ("-".equals(name)) {
                break;
            }
            System.out.print("оценка: ");
            int mark = scan.nextInt();

            marks.put(name, mark);
        }
        final String name = "Ivanov";
        if (marks.containsKey(name)) {
            marks.put(name, marks.get(name) + 1);
        }

        printMap(marks);
    }


    public static void nestedCollectionsDemo1() {
        Map<String, Map<String, Integer>> students = new HashMap<>();  // список студентов
        Map<String, Integer> student;  // студент (оценки по предметам)

        student = new HashMap<>();
        student.put("Введение в программирование", 5);
        student.put("История", 3);
        students.put("Иванов", student);

        student = new HashMap<>();
        student.put("Введение в программирование", 4);
        student.put("Математический анализ", 4);
        student.put("История", 4);
        students.put("Петрова", student);

        for (Map.Entry<String, Map<String, Integer>> studentMarks: students.entrySet()) {
            // String studName = studentMarks.getKey()
            // Map<String, Integer> marks = studentMarks.getValue()
            System.out.printf("%s:%n", studentMarks.getKey());
            for (Map.Entry<String, Integer> subjMark: studentMarks.getValue().entrySet()) {
                // String subjName = subjMark.getKey()
                // int mark = subjMark.getValue()
                System.out.printf("  %s: %s%n", subjMark.getKey(), subjMark.getValue());
            }
        }
    }


    public static void nestedCollectionsDemo2() {
        List<Map<String, Integer>> groups = new ArrayList<>();  // список групп
        Map<String, Integer> group;  // группа (оценки по фамилиям)

        group = new HashMap<>();
        group.put("Ivanov", 4);
        group.put("Petrov", 3);
        groups.add(group);

        group = new HashMap<>();
        group.put("Orlova", 5);
        group.put("Ivlev", 3);
        groups.add(group);

        for (int i = 0; i < groups.size(); i++) {
            System.out.printf("Группа %s:%n", i + 1);
            printMap(groups.get(i));

            // group = groups.get(i);
            // printMap(group);
        }
    }


    public static void pointClassDemo() {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);

        Set<Point> hashSet = new HashSet<>();
        hashSet.add(p1);
        System.out.println("hashSet.contains(p2) -> " + hashSet.contains(p2));

        Set<Point> treeSet = new TreeSet<>();
        treeSet.add(p1);
        System.out.println("treeSet.contains(p2) -> " + treeSet.contains(p2));
    }


    public static void queueDemo() {
        Queue<Integer> q = new LinkedList<>();
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            int value = rnd.nextInt(100);
            q.add(value);
            System.out.printf("add %s%n", value);
        }
        while (!q.isEmpty()) {
            int value = q.poll();
            System.out.printf("poll %s%n", value);
        }
    }

    public static void stackDemo() {
        Stack<Integer> q = new Stack<>();
        Random rnd = new Random();
        for (int i = 0; i < 3; i++) {
            int value = rnd.nextInt(100);
            q.push(value);
            System.out.printf("push %s%n", value);
        }
        while (!q.isEmpty()) {
            int value = q.pop();
            System.out.printf("pop %s%n", value);
        }
    }
}
