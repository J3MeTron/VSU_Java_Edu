package task3.petrov;

import org.jfree.data.xy.XYSeries;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int maxSize = 10010; // максимальный размер массива для сортировки
        int step = 100; // шаг увеличения размера массива

        XYSeries insertionSortComparisons = new XYSeries("Простая сортировка вставками сравнения(Comp)"); //последовательности пар (x, y), где x и y являются числами с плавающей точкой.
        XYSeries binaryInsertionSortComparisons = new XYSeries("Сортировка бинарными вставками сравнения(Comp)");
        XYSeries insertSortSwap = new XYSeries("Простая сортировка вставками замены(Swaps)");
        XYSeries binaryInsertSortSwap = new XYSeries("Сортировка бинарными вставками замены(Swaps)");
        XYSeries insertSortTime = new XYSeries("Простая сортировка вставками время(Time)");
        XYSeries binaryInsertSortTime = new XYSeries("Сортировка бинарными вставками время(Time)");

        for (int size = 10; size <= maxSize; size += step) { //Создаем массивы пока их размер меньше указанного max size
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = (int) (Math.random() * size);
            }

            int[] copyArr1 = arr.clone(); // создаем копию массива для сортировки бинарными вставками

            long[] masSInsert = Sorts.simpleInsertionSort(arr);
            long[] masBInsert = Sorts.binaryInsertionSort(copyArr1);
            long simpleComparisons = masSInsert[0]; //записываем во временные переменные значения comp and swaps
            long binaryComparisons = masBInsert[0];
            long simpleSwaps = masSInsert[1];
            long binarySwaps = masBInsert[1];
            long simpleTime = masSInsert[2];
            long binaryTime = masBInsert[2];

            insertionSortComparisons.add(size, simpleComparisons); //записываем значения в соответствующие переменные класса XYSeries
            binaryInsertionSortComparisons.add(size, binaryComparisons);
            insertSortSwap.add(size, simpleSwaps);
            binaryInsertSortSwap.add(size, binarySwaps);
            insertSortTime.add(size, simpleTime);
            binaryInsertSortTime.add(size, binaryTime);
        }
        SortingComparisonGUI.main(insertionSortComparisons, binaryInsertionSortComparisons, insertSortSwap, binaryInsertSortSwap, insertSortTime, binaryInsertSortTime);
    }
}