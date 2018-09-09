package ru.davidlevi.lesson4.hw;

/**
 * Узел
 */
class Node<T> {
    // Полезные данные
    T data;
    // Ссылки
    Node<T> previous;
    Node<T> next;

    /**
     * Конструктор
     */
    Node(Node<T> previous, T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
}
