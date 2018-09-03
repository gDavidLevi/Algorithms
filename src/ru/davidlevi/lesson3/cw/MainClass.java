package ru.davidlevi.lesson3.cw;

import ru.davidlevi.lesson3.hw.Stack;

/**
 * Урок 3. Стек, очередь и дэк
 */
public class MainClass {
    public static void main(String[] args) {
        // Стек
        // Сложность: O(1) - внесение и извлечение
        Stack stack = new Stack(4);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        //System.out.print(stack.peek());

        // Очередь
        // Сложность: O(1) - внесение и извлечение

    }
}
