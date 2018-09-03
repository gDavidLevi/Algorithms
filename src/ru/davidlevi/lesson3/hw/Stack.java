package ru.davidlevi.lesson3.hw;

import ru.davidlevi.lesson3.cw.Array;

/**
 * Реализация стека
 */
public class Stack {
    private Array stack;
    private int head; // количество элементов в стеке

    // Счетчики
    int parenthesis = 0; // ()
    int lessmore = 0; // <>
    int braces = 0; // {}
    int squareBrackets = 0;

    /**
     * Конструктор
     *
     * @param size int
     */
    public Stack(int size) {
        this.stack = new Array(size);
        this.head = -1; // пустой стек
    }

    /**
     * Пустой ли?
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return head == -1;
    }

    /**
     * Положить знаение
     *
     * @param value int
     */
    public void push(int value) {
        sequencesCounters(value); // Каждый добавленное значение будет проходить проверку
        stack.append(value);
        head++;
    }

    /**
     * Счетчик символов
     *
     * @param charCode
     */
    private void sequencesCounters(int charCode) {
        // Счетчики скобок
        switch (charCode) {
            case (int) '(':
                parenthesis++;
                break;
            case (int) ')':
                parenthesis--;
                break;
            case (int) '<':
                lessmore++;
                break;
            case (int) '>':
                lessmore--;
                break;
            case (int) '{':
                braces++;
                break;
            case (int) '}':
                braces--;
                break;
            case (int) '[':
                squareBrackets++;
                break;
            case (int) ']':
                squareBrackets--;
                break;
            default:
                break;
        }
    }

    /**
     * Возвращает true если последовательность скобок соблюдена
     *
     * @return boolean
     */
    public boolean isBracketsSequencesChecked() {
        return ((parenthesis == 0) & (lessmore == 0) & (braces == 0) & (squareBrackets == 0));
    }


    /**
     * Извлечь значение
     *
     * @return int
     */
    public int pop() {
        int val;
        try {
            val = stack.get(head--);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Стек пуст");
        }
        stack.remove();
        return val;
    }

    /**
     * Извлечь значение справа на лево
     *
     * @return int
     */
    public int backPop() {
        int result = stack.getLastValue(); // получим последний элемент
        stack.delete(head--); // удалить из массива последний элемент и уменьшить вместимость
        return result;
    }

    /**
     * Получить значение
     *
     * @return int
     */
    public int peek() {
        int val;
        try {
            val = stack.get(head);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException("Стек пуст");
        }
        return val;
    }
}
