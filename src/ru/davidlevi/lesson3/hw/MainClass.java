package ru.davidlevi.lesson3.hw;

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
        testDeque();
    }

    /**
     * Дек
     */
    private static void testDeque() {
        Deque deque = new Deque();
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
        deque.insertLeft(4);
        System.out.println(deque);
        deque.insertRight(5);
        deque.insertLeft(6);
        System.out.println(deque);
        deque.removeLeft();
        deque.removeRight();
        System.out.println(deque);
    }

    /**
     * Создать программу, которая переворачивает вводимые строки (Читает справа налево), используя стек
     */
    private static void fromRightToLeft(String string) {
        char[] chars = string.toCharArray();
        int quantity = chars.length;
        // Заполним стек
        Stack stack = new Stack(quantity);
        for (char oneChar : chars)
            stack.push((int) oneChar); // преобразуем символ в int и поместим в стек
        // Результат
        while (!stack.isEmpty())
            System.out.print((char) stack.backPop());
        System.out.println();
    }

    /**
     * Программа проверки скобочных последовательностей () <> {} [] используя стек
     */
    private static void bracketsSequences(String string) {
        char[] chars = string.toCharArray();
        int quantity = chars.length;
        // Заполним стек
        Stack stack = new Stack(quantity);
        for (char oneChar : chars)
            stack.push((int) oneChar);
        // Результат
        System.out.println("Все ли скобки закрыты? Ответ: " + stack.isBracketsSequencesChecked());
    }
}
