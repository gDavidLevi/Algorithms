package ru.davidlevi.lesson2.hw;

/**
 * Урок 2. Массивы и сортировка
 */
public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 2
            Задание:
                1. Дописать методы удаления в классе массива
                2. Улучшить пузырьковую сортировку
                3. Подсчитать количество операций в сортировках и сравнить с их О-большое
                4.* Реализовать сортировку подсчётом
         */

        ArrayInts arrayInts = new ArrayInts(5);
        arrayInts.append(2);
        arrayInts.append(3);
        arrayInts.append(4);
        arrayInts.append(2);
        arrayInts.append(1);
        System.out.println("array" + arrayInts);

        // 1. Дописать методы удаления в классе массива
        arrayInts.delete(1);
        arrayInts.deleteAll(2);
        arrayInts.deleteAll();

        // 2. Улучшить пузырьковую сортировку
        arrayInts.cocktailSort(); // Сортировка перемешиванием или Улучшенная Пузырьковая сортировка

        // 3. Подсчитать количество операций в сортировках и сравнить с их О-большое
        arrayInts.sortBubble();     // Операций: 6      Сложность: O(n^2)
        arrayInts.cocktailSort();   // Операций: 6      Сложность: O(n), в худшем случае O(n^2) если сортировка в обратном порядке
        arrayInts.sortInsert();     // Операций: 7      Сложность: O(n^2), в зависимости от входящих данных может превратиться в O(n log n)
        arrayInts.sortSelect();     // Операций: 4      Сложность: О(n^2)

        // 4.* Реализовать сортировку подсчётом
        arrayInts.countingSort(); // Сортировка подсчётом
    }
}
