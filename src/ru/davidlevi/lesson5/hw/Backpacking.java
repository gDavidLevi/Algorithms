package ru.davidlevi.lesson5.hw;

/**
 * Задача о рюкзаке
 */
class Backpacking {
    /**
     * Метод возвращает максимальное значение, которое может быть помещено в рюкзак емкостью capacity
     *
     * @param capacity int ёмкость
     * @param weights  int[] массив весов
     * @param values   int[] массив значений
     * @param quantity int количество элементов
     * @return int
     */
    static int make(int capacity, int[] weights, int[] values, int quantity) {
        if (quantity == 0 || capacity == 0) return 0; // рюкзак пуст
        // Если вес n-го элемента больше вместимости рюкзака, то данный элемент не может быть включен в решение
        if (weights[quantity - 1] > capacity)
            return make(capacity, weights, values, quantity - 1);
        else {
            int num1 = values[quantity - 1] + make(capacity - weights[quantity - 1], weights, values, quantity - 1);
            int num2 = make(capacity, weights, values, quantity - 1);
            return (num1 > num2) ? num1 : num2; // num1 - элемент включен в решение, а если num1 - не включен
        }
    }
}
