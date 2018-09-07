package ru.davidlevi.lesson4.hw;

import ru.davidlevi.lesson4.cw.Cat;

import java.util.Iterator;

/**
 * Урок 4. Связанные списки
 */
public class MainClass {
    public static void main(String[] args) {
         /*
         Домашняя работа № 4
            Задание:
            1. Реализовать DoubleLinkedList
            2. Проверить все методы итератора
         */
        DoubleLinkedList<Cat> list = new DoubleLinkedList<>();
        list.addFirst(new Cat(4, "4"));     // 4 >
        list.addFirst(new Cat(3, "3"));     // 3 > 4 >
        list.addLast(new Cat(5, "5"));      // 3 > 4 > 5 >
        list.add(new Cat(2, "2"), 0);// 2 > 3 > 4 > 5 >
        list.addFirst(new Cat(1, "1"));     // 1 > 2 > 3 > 4 > 5 >
        list.remove(4);                          // 1 > 2 > 3 > 4 >

        Iterator<Cat> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next().getName() + " > ");
    }
}
