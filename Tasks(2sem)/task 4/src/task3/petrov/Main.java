package task3.petrov;

import org.jfree.data.xy.XYSeries;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        int maxSize = 10000; // максимальный размер массива для сортировки
        int step = 100; // шаг увеличения размера массива
        int srz = 10;
        int n = 0;

        XYSeries insertionSortComparisons = new XYSeries("Простая сортировка вставками сравнения(Comp)"); //последовательности пар (x, y), где x и y являются числами с плавающей точкой.
        XYSeries binaryInsertionSortComparisons = new XYSeries("Сортировка бинарными вставками сравнения(Comp)");
        XYSeries insertSortSwap = new XYSeries("Простая сортировка вставками замены(Swaps)");
        XYSeries binaryInsertSortSwap = new XYSeries("Сортировка бинарными вставками замены(Swaps)");
        XYSeries insertSortTime = new XYSeries("Простая сортировка вставками время(Time)");
        XYSeries binaryInsertSortTime = new XYSeries("Сортировка бинарными вставками время(Time)");

        for (int size = 10; size <= maxSize; size += step) { //Создаем массивы пока их размер меньше указанного max size
            n = 0;

            long[] simpleComparisonsM = new long[srz];
            long[] binaryComparisonsM = new long[srz];
            long[] simpleSwapsM = new long[srz];
            long[] binarySwapsM = new long[srz];
            long[] simpleTimeM = new long[srz];
            long[] binaryTimeM = new long[srz];

            while (n < srz) {
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = (int) (Math.random() * size);
                }

                int[] copyArr1 = arr.clone();
                int[] copyArr2 = arr.clone();
                int[] copyArr3 = arr.clone();
                int[] copyArr4 = arr.clone();
                int[] copyArr5 = arr.clone();// создаем копию массива для сортировки бинарными вставками

                simpleComparisonsM[n] = Sorts.simpleInsertionSort(arr).comparisons;

                binaryComparisonsM[n] = Sorts.binaryInsertionSort(copyArr1).comparisons;

                simpleSwapsM[n] = Sorts.simpleInsertionSort(copyArr2).exchanges;

                binarySwapsM[n] = Sorts.binaryInsertionSort(copyArr3).exchanges;

                simpleTimeM[n] = Sorts.simpleInsertionSort(copyArr4).time;

                binaryTimeM[n] = Sorts.binaryInsertionSort(copyArr5).time;
                n++;
            }
            long simpleComparisons = Sorts.calculateAverage(simpleComparisonsM);
            System.out.print("\n simpleComparisons \n");
            System.out.print(simpleComparisons);
            System.out.print("\n");

            long binaryComparisons = Sorts.calculateAverage(binaryComparisonsM);
            System.out.print("\n binaryComparisons \n");
            System.out.print(binaryComparisons);
            System.out.print("\n");

            long simpleSwaps = Sorts.calculateAverage(simpleSwapsM);
            System.out.print("\n simpleSwaps \n");
            System.out.print(simpleSwaps);
            System.out.print("\n");

            long binarySwaps = Sorts.calculateAverage(binarySwapsM);
            System.out.print("\n binarySwaps \n");
            System.out.print(binarySwaps);
            System.out.print("\n");

            long simpleTime = Sorts.calculateAverage(simpleTimeM);
            System.out.print("\n simpleTime \n");
            System.out.print(simpleTime);
            System.out.print("\n");

            long binaryTime = Sorts.calculateAverage(binaryTimeM);
            System.out.print("\n binaryTime \n");
            System.out.print(binaryTime);
            System.out.print("\n");
            System.out.print("------------------\n");

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