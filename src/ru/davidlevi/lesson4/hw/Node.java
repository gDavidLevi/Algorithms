package ru.davidlevi.lesson4.hw;

/**
 * Узел
 */
class Node<T> {
    // Полезные данные
    T data;
    // Ссылки
    Node<T> prev;
    Node<T> next;

    /**
     * Конструктор
     */
    Node(Node<T> prev, T data, Node<T> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
