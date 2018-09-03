package ru.davidlevi.lesson3.cw;

/**
 * Реализация очереди
 */
public class Queue {
    private int capacity; // вместимость очереди
    private int[] queue; // массив
    private int head; // индекс головного элемента
    private int tail; // индекс хвостового элемента
    private int quantity; // действительное количество элементов

    /**
     * Конструктор
     *
     * @param size int
     */
    public Queue(int size) {
        this.capacity = size;
        queue = new int[size];
        head = 0; // очередь пустая
        tail = -1; // очередь пустая
    }

    /**
     * Пустой ли?
     *
     * @return boolean
     */
    private boolean isEmpty() {
        return quantity == 0;
    }

    /**
     * Заполнена ли очередь?
     *
     * @return boolean
     */
    private boolean isFull() {
        return quantity == capacity; // если количество равно вместимости, то true иначе false
    }

    /**
     * Размер
     *
     * @return int
     */
    public int size() {
        return quantity;
    }

    /**
     * Добавить в очередь?
     *
     * @param i int
     */
    public void insert(int i) {
        // Если очередь заполнена, то...
        if (isFull()) {
            capacity *= 2; // увеличить размер массива в 2 раза
            int[] temp = new int[capacity]; // создать временнный массив
            // Если размер индекс хвосторого элемента >= и. головного элемента, то...
            if (tail >= head) {
                System.arraycopy(queue, 0, temp, 0, queue.length);
            } else { //... иначе...
                System.arraycopy(queue, 0, temp, 0, tail + 1);
                System.arraycopy(queue, head,
                        temp, capacity - (queue.length - head),
                        queue.length - head - 1);
                head = capacity - head - 1;
            }
            // Готовая новая очередь
            queue = temp;
        }
        if (tail == capacity - 1)
            tail = -1;
        // Добавим новый элемент в массив большего размера
        queue[++tail] = i;
        // Количество элементов
        quantity++;
    }

    /**
     * Удаление или извлечение элемента из очереди
     *
     * @return int
     */
    public int remove() {
        if (isEmpty())
            throw new RuntimeException("Очередь пуста");
        int temp = queue[head++]; // сохраним последний элемент из массива
        head %= capacity; //todo ...
        quantity--; // уменьшим действительно количество элементов
        return temp; // вернем сохраненный элемент
    }

    /**
     * Возвращает элемент очереди
     *
     * @return int
     */
    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Очередь пуста");
        return queue[head];
    }
}