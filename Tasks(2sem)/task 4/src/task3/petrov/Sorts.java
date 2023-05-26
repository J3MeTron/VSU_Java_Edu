package task3.petrov;

public class Sorts {
    public static OutputСomparisons binaryInsertionSort(int[] array) {
        int comparisons = 0;
        int exchanges = 0;
        int n = array.length;

        long startTime = System.nanoTime();

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int left = 0;
            int right = i - 1;

            // Бинарный поиск позиции для вставки элемента
            while (left <= right) {
                int mid = (left + right) / 2;
                comparisons++;
                if (array[mid] > key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Сдвиг элементов для освобождения места для вставки
            for (int j = i - 1; j >= left; j--) {
                array[j + 1] = array[j];
                exchanges++;
            }

            array[left] = key; // Вставка элемента
            exchanges++;
            }
        long endTime = System.nanoTime();
        long binaryInsertionTime = endTime - startTime;


        OutputСomparisons output = new Sorts.OutputСomparisons();
        output.comparisons = comparisons;
        output.exchanges = exchanges;
        output.time = binaryInsertionTime;
        return output;
    }
    public static class OutputСomparisons {
        public long comparisons;
        public long exchanges;
        public long time;
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

    public static OutputСomparisons simpleInsertionSort(int[] array) {
        int[] array2 = array;
        int comparisons = 0;
        int exchanges = 0;
        int n = array.length;

        long startTime = System.nanoTime();

        for (int i = 1; i < n; i++) {
            int key = array2[i];
            int j = i - 1;

            while (j >= 0 && array2[j] > key) {
                array2[j + 1] = array2[j];
                j--;
                comparisons++;
                exchanges++;
            }

            array2[j + 1] = key;
            exchanges++;

        }
        long endTime = System.nanoTime();
        long simpleInsertionTime = endTime - startTime;

        OutputСomparisons output = new Sorts.OutputСomparisons();
        output.comparisons = comparisons;
        output.exchanges = exchanges;
        output.time = simpleInsertionTime;
        return output;
    }

    /*Перебираем все элементы массива, начиная со второго.
    1. Берем текущий элемент и сравниваем его с предыдущими элементами.
    2. Если предыдущий элемент больше текущего, перемещаем его вправо на одну позицию.
    3. Повторяем шаг 3, пока не найдем место для текущего элемента.
    4. Вставляем текущий элемент на найденное место.
    5. Повторяем шаги 2-5 для всех элементов массива.*/

    public static long calculateAverage(long[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (long) sum / array.length;
    }

}
