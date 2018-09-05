package ru.davidlevi.lesson3.hw;

/**
 * Приоритетная очередь
 */
public class PriorityQueue extends Queue {

    /**
     * Конструктор
     *
     * @param size int
     */
    public PriorityQueue(int size) {
        super(size);
    }

    /**
     * Вставка
     * Сдвигаем вправо всё и вставляем значение
     *
     * @param value int
     */
    @Override
    public void insert(int value) {
        if (isFull()) throw new RuntimeException("Очередь заполнена");
        int i;
        for (i = 0; i < getQuantity(); i++)
            if (getQueue()[i] > value) break;
        System.arraycopy(getQueue(), i, getQueue(), i + 1, getQuantity() - i);
        getQueue()[i] = value;
        setQuantity(getQuantity() + 1);
    }

    /**
     * Удаление/Извлечение
     *
     * @return int
     */
    @Override
    public int remove() {
        if (isEmpty()) throw new RuntimeException("Очередь пуста");
        int result = getQueue()[0];
        System.arraycopy(getQueue(), 1, getQueue(), 0, getQuantity());
        setQuantity(getQuantity() - 1);
        return result;
    }
}
