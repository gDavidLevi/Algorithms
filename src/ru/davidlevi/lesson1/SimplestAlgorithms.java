package ru.davidlevi.lesson1;

class SimplestAlgorithms {
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
        float count = 1;
        while (degree > 0) {
            if (degree % 2 == 0) {
                degree /= 2;
                base *= base;
            } else {
                degree -= 1;
                count *= base;
            }
        }
        return count;
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
     * Сложность: O(log n)
     *
     * @param min   int
     * @param array int
     * @param index int
     * @return int
     */
    static int findMinRec(int min, int array[], int index) {
        if (index < 0) return min;
        if (min > array[index]) min = array[index];
        return findMinRec(min, array, index - 1);
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
        for (int element : array) sum += element;
        return sum / (float) array.length;
    }
}
