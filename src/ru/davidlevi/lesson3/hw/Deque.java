package ru.davidlevi.lesson3.hw;

/**
 * Реализация двусторонней очереди
 * англ. deque — double ended queue
 */
public class Deque extends Queue {
    private int counter; // счетчик элементов о очереди

    /**
     * Конструктор
     */
    public Deque() {
        super(0);
    }

    /**
     * Добавить элемент слева в дек
     *
     * @param value int
     */
    public void insertLeft(int value) {
        counter++; // новая длинна массива
        int[] temp = getQueue();
        int[] newArray = new int[counter]; // новый массив
        newArray[0] = value; // вставлем слева value
        System.arraycopy(temp, 0, newArray, 1, temp.length); // копируем остальное
        setQueue(newArray, counter); // актуализировать очередь
    }

    /**
     * Добавить элемент справа в дек
     *
     * @param value int
     */
    public void insertRight(int value) {
        counter++; // новая длинна массива
        int[] temp = getQueue();
        int[] newArray = new int[counter]; // новый массив
        newArray[newArray.length - 1] = value; // вставлем справа value
        System.arraycopy(temp, 0, newArray, 0, temp.length); // копируем остальное
        setQueue(newArray, counter); // актуализировать очередь
    }

    /**
     * Возвращает удаленный слева элемент из дека
     *
     * @return int
     */
    public int removeLeft() {
        if (isEmpty()) throw new RuntimeException("Очередь пуста");
        counter--; // новая длинна массива
        int[] temp = getQueue();
        int[] newArray = new int[counter]; // новый массив
        System.arraycopy(temp, 1, newArray, 0, counter); // cp
        setQueue(newArray, counter); // актуализировать очередь
        return temp[0];
    }

    /**
     * Возвращает удаленный справа элемент из дека
     *
     * @return int
     */
    public int removeRight() {
        if (isEmpty()) throw new RuntimeException("Очередь пуста");
        counter--; // новая длинна массива
        int[] temp = getQueue();
        int[] newArray = new int[counter]; // новый массив
        System.arraycopy(temp, 0, newArray, 0, counter); // cp
        setQueue(newArray, counter); // актуализировать очередь
        return temp[temp.length - 1];
    }

    @Override
    public String toString() {
        int iMax = counter - 1;
        if (iMax == -1) return "[]";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; ; i++) {
            stringBuilder.append(getQueue()[i]);
            if (i == iMax)
                return stringBuilder.append(']').toString();
            stringBuilder.append(", ");
        }
    }
}
