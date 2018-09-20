package ru.davidlevi.lesson8.hw;

/**
 * Урок 8. Хеш-таблицы
 */
public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 8
            Задание:
                1. Реализовать программу, реализующую метод цепочек.
         */
        int size = 7;
        MyHashTable table = new MyHashTable(size);

        // Заполняем
        for (int i = 0; i < size; i++)
            table.insert(new MyHashTable.Element(i));
        table.insert(new MyHashTable.Element(1)); // будет две единицы в table

        // Отображение
        System.out.println(table);
//        0
//        1 1
//        2
//        3
//        4
//        5
//        6

        // Поиск значения 1
        int find = 1;
        if (table.find(find).getData() == find)
            System.out.println("Имееется такое значение"); // Имееется такое значение
        else
            System.out.println("Значение отсутствует");
    }
}
