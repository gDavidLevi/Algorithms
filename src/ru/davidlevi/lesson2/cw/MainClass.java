package ru.davidlevi.lesson2.cw;

import ru.davidlevi.lesson2.hw.ArrayInts;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Урок 2. Массивы и сортировка
 */
public class MainClass {
    public static void main(String[] args) {
        int[] array = new int[5];
        System.out.println(array.length);
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println(array2[4]);
        System.out.println(Arrays.toString(array2));

        ArrayInts arrayInts = new ArrayInts(5);
        arrayInts.append(1);
        arrayInts.append(2);
        arrayInts.append(3);
        System.out.println(arrayInts);
        arrayInts.append(4);
        arrayInts.append(5);
        arrayInts.append(6);
        arrayInts.append(7);
        arrayInts.append(8);
        System.out.println(arrayInts);
        arrayInts.remove();
        arrayInts.remove();
        System.out.println(arrayInts);

        // Итератор
//        String[] catsNames = {"Васька", "Кузя"};
//        List<String> list = Arrays.asList(catsNames);
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
    }
}
