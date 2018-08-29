package ru.davidlevi.lesson1.hw;

/**
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 * <p>
 * Список функций:
 * pow - Возведение в степень
 * quickPow - Возведение в степень используя чётность степени
 * powRecursion - Возведение в степень рекурсивно
 * findMin - Поиск минимального элемента
 * findMinRecursion - Поиск минимального элемента рекурсивно
 * average - Нахождение среднего арифметического
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
}
