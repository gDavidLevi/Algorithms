package ru.davidlevi.lesson4.hw;

import java.util.*;

/**
 * DoubleLinkedList - двусвязный список, где каждый элемент содержит ссылки на предыдущий и следующий элементы.
 */
public class DoubleLinkedList<T> {
    private Node<T> firstNode; // первый узел списка
    private Node<T> lastNode; // последний узел списка
    private int counterMod; // количество модификаций списка во время работы иттератора
    private int quantity; // количество действительных элементов в списке

    /**
     * Конструктор
     */
    DoubleLinkedList() {
    }

    /**
     * Размер списка
     *
     * @return int
     */
    int size() {
        return quantity;
    }

    /**
     * Пустой ли список?
     *
     * @return boolean
     */
    boolean isEmpty() {
        return quantity == 0;
    }

    /**
     * Добавление элемента вначало списка
     *
     * @param object T
     * @return boolean
     */
    boolean addFirst(T object) {
        Node<T> newNode = new Node<>(null, object, firstNode);
        if (firstNode != null)
            firstNode.previous = newNode;
        else
            lastNode = newNode;
        firstNode = newNode;
        quantity++;
        counterMod++;
        return true;
    }

    /**
     * Метод возвращает узел по индексу
     *
     * @param index int
     * @return T
     */
    T get(int index) {
        Node<T> result = getNode(index);
        return result == null ? null : result.data;
    }

    /**
     * Добавить узел в позицию по индексу
     *
     * @param object T
     * @param index  int
     * @return boolean
     */
    boolean add(T object, int index) {
        if (index < 0)
            throw new IndexOutOfBoundsException("index = " + index);
        if (quantity == 0 || index == 0)
            return addFirst(object);
        Node<T> current = firstNode;
        for (int j = 1; (j < index) && (j < quantity); j++)
            current = current.next;
        return addAfter(current, object);
    }

    /**
     * Добавить в конец списка
     *
     * @param object T
     * @return boolean
     */
    boolean addLast(T object) {
        Node<T> node = lastNode;
        Node<T> newNode = new Node<T>(node, object, null); // создаем новый элемент
        lastNode = newNode;
        // Правим ссылки
        if (node == null)
            firstNode = newNode;
        else
            node.next = newNode;
        quantity++;
        counterMod++;
        return true;
    }

    /**
     * Извлекает узел по индексу из списка
     *
     * @param index int
     * @return T
     */
    T remove(int index) {
        Node<T> node = getNode(index);
        if (node == null) return null;
        return remove(node);
    }

    /**
     * Итератор
     *
     * @return Iterator<T>
     */
    Iterator<T> iterator() {
        return new ThisIterator(0); // сначала
    }

    /**
     * Удаление узла
     *
     * @param node Node<T>
     * @return T
     */
    private T remove(Node<T> node) {
        T oldData = node.data;
        Node<T> prevNode = node.previous;
        Node<T> nextNode = node.next;
        // Правим ссылки
        if (prevNode == null)  // если первый элемент, то...
            firstNode = node.next;
        else {
            prevNode.next = nextNode;
            node.previous = null;
        }
        if (nextNode == null)   // если узел последний в списке, то ...
            lastNode = node.previous;
        else {
            nextNode.previous = prevNode;
            node.next = null;
        }
        node.data = null;
        quantity--;
        counterMod++;
        return oldData; // вернуть то, что отвязали
    }

    /**
     * Добавить узел после текущего
     *
     * @param current Node<T>
     * @param object  T
     * @return boolean
     */
    private boolean addAfter(Node<T> current, T object) {
        Node<T> newNode = new Node<>(current, object, current.next);
        // Правим ссылки
        if (current.next == null)
            lastNode = newNode;
        else
            current.next.previous = newNode;
        current.next = newNode;
        quantity++;
        counterMod++;
        return true;
    }

    /**
     * Извлечь из списка узел по индексу
     *
     * @param index int
     * @return Node<T>
     */
    private Node<T> getNode(int index) {
        if (index >= quantity) return null;
        Node<T> result = null;
        if (index < (quantity >> 1)) {
            result = firstNode;
            for (int j = 0; j < index; j++)
                result = result.next;
            return result;
        } else {
            result = lastNode;
            for (int j = quantity - 1; j > index; j--)
                result = result.previous;
            return result;
        }
    }

    // ================================================================================================================

    /**
     * Переборщик
     */
    private class ThisIterator implements ListIterator<T> {
        private Node<T> lastNode = null;
        private Node<T> nextNode;
        private int nextIndex;
        private int saveMod = counterMod; // количество изменений до начала перебора

        /**
         * Конструктор
         *
         * @param index начало перебора
         */
        ThisIterator(int index) {
            nextNode = (index == quantity) ? null : getNode(index);
            nextIndex = index;
        }

        /**
         * Производились ли внешние изменения списка во время перебора?
         */
        private void check() {
            if (counterMod != saveMod) throw new ConcurrentModificationException();
        }

        /**
         * Есть ли следующий?
         *
         * @return boolean
         */
        @Override
        public boolean hasNext() {
            return nextIndex < quantity;
        }

        /**
         * Возвращает слудующий узел (к концу списка)
         *
         * @return T
         */
        @Override
        public T next() {
            check();
            if (!hasNext())
                throw new NoSuchElementException(); // перебраны все элементы
            // Возвращаем узел и сдвигаем ссылки
            lastNode = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastNode.data;
        }

        /**
         * Есть ли предыдущий?  (к началу списка)
         *
         * @return boolean
         */
        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        /**
         * Возвращает предыдущий узел (к началу списка)
         *
         * @return T
         */
        @Override
        public T previous() {
            check();
            if (!hasPrevious())
                throw new NoSuchElementException(); // перебраны все элементы
            // Возвращаем узел и сдвигаем ссылки
            lastNode = nextNode = (nextNode == null) ? DoubleLinkedList.this.lastNode : nextNode.previous;
            nextIndex--;
            return lastNode.data;
        }

        /**
         * Следующий индекс
         *
         * @return int
         */
        @Override
        public int nextIndex() {
            return nextIndex;
        }

        /**
         * Предудущий индекс
         *
         * @return int
         */
        @Override
        public int previousIndex() {
            return nextIndex - 1;
        }

        /**
         * Удалить из списка последний узел
         */
        @Override
        public void remove() {
            check();
            if (lastNode == null)
                throw new IllegalStateException(); // нечего удалять
            Node<T> lastNext = lastNode.next;
            DoubleLinkedList.this.remove(lastNode); // удаляем нужный узел
            // Правим ссылки
            if (nextNode == lastNode)
                nextNode = lastNext;
            else
                nextIndex--;
            lastNode = null;
            saveMod++;
        }

        /**
         * Меняет значение последнего элемента, который вернул итератор
         * Важно! Нельзя вызывать после вызовов методов add() и remove() итератора
         *
         * @param object T
         */
        @Override
        public void set(T object) {
            if (lastNode == null)
                throw new IllegalStateException();
            check();
            lastNode.data = object;
        }

        /**
         * Добавляет новый элемент перед элементом, который вернет метод nextNode()
         *
         * @param object T
         */
        @Override
        public void add(T object) {
            check();
            lastNode = null;
            DoubleLinkedList.this.add(object, nextIndex);
            nextIndex++;
            saveMod++;
        }
    }
}