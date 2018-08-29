package ru.davidlevi.lesson1.hw;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * <p>
 * Список функций:
 * pow - Возведение в степень
 * quickPow - Возведение в степень используя чётность степени
 * powRecursion - Возведение в степень рекурсивно
 * average - Нахождение среднего арифметического
 * Поиск:
 * findMin - Поиск минимального элемента
 * findMinRecursion - Поиск минимального элемента рекурсивно
 * binarySearch - Бинарный поиск
 * Сортировки:
 * bubbleSort - Пузырьковая сортировка
 * quickSort - Быстрая сортировка
 * hoarSort - Сортировка Хоара (улучшенная Быстрая сортировка)
 * pigeonholeSort - Сортировка Pigeonhole (сильно жрёт память!)
 * selectionSort - Сортировка методом выбора
 * insertionSort - Сортировка вставками
 * cocktailSort - Сортировка перемешиванием, или Шейкерная сортировка, или двунаправленная (англ. Cocktail sort), или улучшенная Пузырьковая сортировка
 * countingSort - Сортировка подсчётом
 */
class SimplestAlgorithms {

    /**
     * Возведение в степень
     * Сложность: O(n)
     *
     * @param base   float
     * @param degree int
     * @return double
     */
    static double pow(float base, int degree) {
        int result = 1;
        int i = 0;
        while (i < degree) {
            result *= base;
            i++;
        }
        return result;
    }

    /**
     * Возведение в степень используя чётность степени
     * Сложность: O(log n)
     *
     * @param base   основание
     * @param degree степень
     * @return double
     */
    static double quickPow(float base, int degree) {
        if (degree == 0) return 1;
        float result = 1;
        while (degree > 0) {
            if (degree % 2 == 0) {
                degree /= 2;
                base *= base;
            } else {
                degree -= 1;
                result *= base;
            }
        }
        return result;
    }

    /**
     * Возведение в степень рекурсивно
     * Сложность: O(n)
     *
     * @param base   float
     * @param degree int
     * @return double
     */
    static double powRecursion(float base, int degree) {
        if (degree == 0) return 1;
        return powRecursion(base, --degree) * base;
    }

    /**
     * Поиск минимального элемента
     * Сложность: O(n)
     *
     * @param array int[]
     * @return int
     */
    static int findMin(int[] array) {
        int min = array[0];
        for (int element : array)
            if (element < min) min = element;
        return min;
    }

    /**
     * Поиск минимального элемента рекурсивно
     * Сложность: O(n)
     *
     * @param min   int
     * @param array int
     * @param index int
     * @return int
     */
    static int findMinRecursion(int min, int array[], int index) {
        if (index < 0) return min;
        if (min > array[index]) min = array[index];
        return findMinRecursion(min, array, index - 1);
    }

    /**
     * Нахождение среднего арифметического
     * Сложность: O(n)
     *
     * @param array int[]
     * @return float
     */
    static float average(int[] array) {
        int sum = 0;
        for (int element : array) sum += element; // или int sum = Arrays.stream(array).sum();
        return sum / (float) array.length;
    }

    /**
     * Пузырьковая сортировка
     * Сложность: O(n^2)
     *
     * @param array int[]
     */
    static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
        }
    }

    /**
     * Быстрая сортировка
     * Сложность: O(n log n)
     * <p>
     * int low = 0;
     * int high = x.length - 1;
     * quickSort(x, low, high);
     *
     * @param array     int[]
     * @param lowIndex  int
     * @param highIndex int
     */
    static void quickSort(@NotNull int[] array, int lowIndex, int highIndex) {
        if (array.length == 0) return; // завершить выполнение если длина массива равна 0
        if (lowIndex >= highIndex) return; // завершить выполнение если уже нечего делить

        // Выбрать опорный элемент
        int middle = lowIndex + (highIndex - lowIndex) / 2;
        int opora = array[middle];

        // Разделить на подмассивы, который больше и меньше опорного элемента
        int i = lowIndex, j = highIndex;
        while (i <= j) {
            while (array[i] < opora) i++;
            while (array[j] > opora) j--;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        // Вызов рекурсии для сортировки левой и правой части
        if (lowIndex < j) quickSort(array, lowIndex, j);
        if (highIndex > i) quickSort(array, i, highIndex);
    }

    /**
     * Бинарный поиск
     * Сложность:  O(log n)
     *
     * @param array @NotNull int[]
     * @param value int
     * @return int. -1 если не найдено значение
     */
    static int binarySearch(@NotNull int[] array, int value) {
        // Сначала всё сортируем
        quickSort(array, 0, array.length - 1);
        // Теперь ищем бинарным поиском
        int result = -1;
        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
            mid = (low + high) >>> 1; // >>> для того, чтобы не возникло переполнение целого http://proglang.su/java/operators
            if (value == array[mid]) {
                result = mid;
                break;
            } else {
                if (value <= array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return result;
    }

    /**
     * Метод разбивает массив относительно опорного элемента для сортировки Хоара
     *
     * @param array @NotNull int[]
     * @param start int
     * @param end   int
     * @return int
     */
    private static int partition(@NotNull int[] array, int start, int end) {
        int marker = start;
        for (int i = start; i <= end; i++) {
            if (array[i] <= array[end]) {
                swap(array, marker, i);
                marker += 1;
            }
        }
        return marker - 1;
    }

    /**
     * Сортировка Хоара (улучшенная Быстрая сортировка)
     * Сложность: O(n log n)
     *
     * @param array      @NotNull int[]
     * @param lowIndex   int
     * @param hightIndex int
     */
    static void hoarSort(@NotNull int[] array, int lowIndex, int hightIndex) {
        if (lowIndex >= hightIndex) return;
        // Разбиение массива относительно опорного элемента
        int pivot = partition(array, lowIndex, hightIndex);
        // Рекурсивная сортировка каждой части массива
        hoarSort(array, lowIndex, pivot - 1);
        hoarSort(array, pivot + 1, hightIndex);
    }

    /**
     * Сортировка Pigeonhole (сильно жрёт память!)
     * Сложность:
     *
     * @param array @NotNull int[]
     * @param size  int
     */
    static void pigeonholeSort(@NotNull int[] array, int size) {
        int min = array[0];
        int max = array[0];
        int range, i, j, index;
        for (int a = 0; a < size; a++) {
            if (array[a] > max) max = array[a];
            if (array[a] < min) min = array[a];
        }
        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);
        for (i = 0; i < size; i++) phole[array[i] - min]++;
        index = 0;
        for (j = 0; j < range; j++)
            while (phole[j]-- > 0)
                array[index++] = j + min;
    }

    /**
     * Сортировка методом выбора
     * Сложность: О(n^2)
     *
     * @param array @NotNull int[]
     */
    static void selectionSort(@NotNull int[] array) {
        // По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...)
        for (int min = 0; min < array.length - 1; min++) {
            // Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
            int least = min;
            // В оставшейся части подмножества ищем элемент, который меньше предположенного минимума
            for (int j = min + 1; j < array.length; j++)
                if (array[j] < array[least])
                    least = j;
            // Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами
            swap(array, min, least);
        }
    }

    /**
     * Сортировка вставками
     * Сложность: O(n^2), в зависимости от входящих данных может превратиться в O(n log n)
     *
     * @param array @NotNull int[]
     * @return int[]
     */
    static int[] insertionSort(@NotNull int[] array) {
        int[] result = new int[array.length];
        int size = 0;
        for (int n = 0; n < array.length; n++) {
            // Ищем место для вставки
            int index = 0;
            if (size > 0)
                while (index < size && result[index] < array[n])
                    index++;
            // Вставка
            for (int m = size - 1; m >= index; m--)
                result[m + 1] = result[m];
            result[index] = array[n];
            size++;
        }
        return result;
    }

    /**
     * Сортировка перемешиванием, или Шейкерная сортировка, или двунаправленная (англ. Cocktail sort), или улучшенная Пузырьковая сортировка
     * Сложность: O(n), в худшем случае O(n^2) если сортировка в обратном порядке
     *
     * @param array @NotNull int[]
     */
    static void cocktailSort(@NotNull int[] array) {
        int buff;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    /**
     * Сортировка подсчётом
     * Сложность:
     * [min;max] указывают диапазон сортировки, чем он уже тем он быстрее
     *
     * @param array      @NotNull int[]
     * @param minElement int
     * @param maxElement int
     */
    static void countingSort(@NotNull int[] array, int minElement, int maxElement) {
        for (int element : array) {
            if (element < minElement) minElement = element;
            if (element > maxElement) maxElement = element;
        }
        int[] buckets = new int[maxElement - minElement + 1];
        for (int element : array)
            buckets[element - minElement]++;
        int arrayIndex = 0;
        for (int i = 0; i < buckets.length; i++)
            for (int j = buckets[i]; j > 0; j--)
                array[arrayIndex++] = i + minElement;
    }

    /**
     * Поиск минимального элемента в массиве
     *
     * @param array @NotNull int[]
     * @return int
     */
    static int minElement(@NotNull int[] array) {
        if (array.length > 0) {
            int min = array[0];
            for (int element : array)
                if (element < min) min = element;
            return min;
        } else throw new IllegalArgumentException();
    }

    /**
     * Поиск максимального элемента в массиве
     *
     * @param array @NotNull int[]
     * @return int
     */
    static int maxElement(@NotNull int[] array) {
        if (array.length > 0) {
            int max = array[0];
            for (int element : array)
                if (element > max) max = element;
            return max;
        } else throw new IllegalArgumentException();
    }


    /**
     * Метод меняет местами значения переменных
     *
     * @param a int
     * @param b int
     */
    private static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    /**
     * Метод меняет местами значения элементов массива
     *
     * @param array  @NotNull int[]
     * @param first  int
     * @param second int
     */
    private static void swap(@NotNull int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}