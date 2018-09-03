package ru.davidlevi.lesson3.hw;

import ru.davidlevi.lesson3.cw.Stack;

/**
 * Урок 3. Стек и очередь
 */
public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 3
            Задание:
                1. Реализовать программу проверки скобочных последовательностей () <> {} [] используя стек
                2. Создать программу, которая переворачивает вводимые строки (Читает справа налево), используя стек
                3. Создать классы для реализации дека и приоритетной очереди.
         */

        String string = "<{}слово1 (слово2)<>слово3[]>";
        // 1.
        bracketsSequences(string);
        // 2.
        fromRightToLeft(string);
        // 3.
    }

    /**
     * Создать программу, которая переворачивает вводимые строки (Читает справа налево), используя стек
     */
    private static void fromRightToLeft(String string) {
        char[] cArray = string.toCharArray();
        int quantity = cArray.length;
        // Заполним стек
        Stack stack = new Stack(quantity);
        for (int i = 0; i < quantity; i++)
            stack.push((int) cArray[i]); // char to int
        // Вывод в обратном порядке
        while (!stack.isEmpty())
            System.out.print((char) stack.backPop());
        System.out.println();
    }

    /**
     * Программа проверки скобочных последовательностей () <> {} [] используя стек
     */
    private static void bracketsSequences(String string) {
        char[] cArray = string.toCharArray();
        int quantity = cArray.length;
        // Заполним стек
        Stack stack = new Stack(quantity);
        for (int i = 0; i < quantity; i++)
            stack.push((int) cArray[i]); // char to int
        System.out.println("Все ли скобки закрыты? Ответ: " + stack.isBracketsSequencesChecked());
    }
}
