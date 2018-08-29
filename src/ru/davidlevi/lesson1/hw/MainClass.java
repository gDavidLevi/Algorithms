package ru.davidlevi.lesson1.hw;

/**
 * Урок 1. Общие сведения об алгоритмах и структурах данных
 */
public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 1
            Задание:
                1 Описать простейшие алгоритмы
                11 Возведение в степень *используя чётность степени*
                12 *рекурсивный* Поиск минимального элемента в массиве
                13 Нахождение среднего арифметического массива
                2 Подсчитать сложность описанных алгоритмов
                3 Какие правила подсчёта применялись, оставьте комментарии в коде
         См. https://habr.com/post/188010/
         */
        int[] arrayInteger = {13, 24, 35, 7, 14, 20, 54, -7, -15, 10, 31};
        System.out.println(SimplestAlgorithms.pow(2f, 6)); // 64.0
        System.out.println(SimplestAlgorithms.quickPow(2f, 6)); // 64.0
        System.out.println(SimplestAlgorithms.powRecursion(2f, 6)); // 64.0
        System.out.println(SimplestAlgorithms.findMin(arrayInteger)); // -15
        System.out.println(SimplestAlgorithms.findMinRecursion(arrayInteger[arrayInteger.length - 1], arrayInteger, arrayInteger.length - 1)); // -15
        System.out.println(SimplestAlgorithms.average(arrayInteger)); // 16.90909
    }
}
