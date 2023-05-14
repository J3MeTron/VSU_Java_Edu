package task3.petrov;

import java.util.Arrays;

public class Sorts {
    public static long[] binaryInsertionSort(int[] array) {
        int comparisons = 0;
        int exchanges = 0;
        int n = array.length;

        long startTime = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int left = 0;
            int right = i - 1;

            int j = binarySearch(array, key, left, right);
            comparisons += j - left;

            while (right >= j) {
                array[right + 1] = array[right];
                right--;
                exchanges++;
            }

            array[j] = key;
            exchanges++;
        }
        long endTime = System.nanoTime();
        long binaryInsertionTime = endTime - startTime;
        System.out.println("Size of array: " + array.length);
        System.out.println("Binary Insertion Sort Comparisons: " + comparisons);
        System.out.println("Binary Insertion Sort Swaps: " + exchanges);
        System.out.println("Binary Insertion Sort Time(ms): " + binaryInsertionTime);
        long[] compSize = new long[3];
        compSize[0] = comparisons;
        compSize[1] = exchanges;
        compSize[2] = binaryInsertionTime;
        return compSize;
    }

    public static int binarySearch(int[] array, int key, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid + 1;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static long[] simpleInsertionSort(int[] array) {
        int comparisons = 0;
        int exchanges = 0;
        int n = array.length;

        long startTime = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                comparisons++;
                exchanges++;
            }

            array[j + 1] = key;
            exchanges++;
        }
        long endTime = System.nanoTime();
        long simpleInsertionTime = endTime - startTime;
        System.out.println("Size of array: " + array.length);
        System.out.println("Insertion Sort Comparisons: " + comparisons);
        System.out.println("Insertion Sort Swaps: " + exchanges);
        System.out.println("Insertion Sort Time(ms): " + simpleInsertionTime);
        long[] compSize = new long[3];
        compSize[0] = comparisons;
        compSize[1] = exchanges;
        compSize[2] = simpleInsertionTime;
        return compSize;
    }
    /*Перебираем все элементы массива, начиная со второго.
    1. Берем текущий элемент и сравниваем его с предыдущими элементами.
    2. Если предыдущий элемент больше текущего, перемещаем его вправо на одну позицию.
    3. Повторяем шаг 3, пока не найдем место для текущего элемента.
    4. Вставляем текущий элемент на найденное место.
    5. Повторяем шаги 2-5 для всех элементов массива.*/
}
