package ru.davidlevi.lesson5.hw;

/**
 * Урок 5. Рекурсия
 */
public class MainClass {
    public static void main(String[] args) {
         /*
         Домашняя работа № 5
            Задание:
                1. Ханойская башня
                2. Обойти конём шахматную доску наступив на каждую клетку по одному разу и не наступив ни на одну дважды
                3. ***Написать программу «Задача о рюкзаке» с помощью рекурсии.
         */

        // Ханойская башня
        HanoiTower.make(3, "А", "Б", "В");

        // Задача о шахматном коне
        System.out.println(ChessKnight.probability(0, 0, 3)); // 0.125
        System.out.println(ChessKnight.probability(0, 0, 1)); // 0.25
        System.out.println(ChessKnight.probability(1, 2, 2)); // 0.5
        System.out.println(ChessKnight.probability(1, 2, 1)); // 0.75

        // Задача о рюкзаке
        int capacity = 60;
        int[] weights = new int[]{1, 2, 3};
        int[] values = new int[]{6, 10, 12};
        int quantity = values.length;
        System.out.println(Backpacking.make(capacity, weights, values, quantity)); // 28
    }
}
