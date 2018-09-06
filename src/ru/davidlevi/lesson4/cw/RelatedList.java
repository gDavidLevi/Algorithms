package ru.davidlevi.lesson4.cw;

import java.util.Objects;

/**
 * RelatedList - это аналог класса LinkedList
 * <p>
 * RelatedList cложность поиска одного элемента: O(n)
 * ArrayList cложность поиск одного элемента: O(1)
 *
 * @param <T> некий объект
 */
public class RelatedList<T> {
    /**
     * Класс(тип) Node (узел)
     * Хранит то, чем мы будет оперировать в RelatedList
     *
     * @param <T> тип объекта
     */
    private class Node<T> {
        T object; // сам полезный объект
        Node<T> previousNode; // ссылка на предыдущий узел

        public Node(T object) {
            this.object = object;
        }

        @Override
        public String toString() {
            return object.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<T> node = (Node) o;
            return Objects.equals(object, node.object);
        }
    }

    private Node<T> lastNode; // будет хранить ссылку на последний узел

    /**
     * Конструктор
     */
    public RelatedList() {
        lastNode = null; // то есть пустой список
    }

    /**
     * Пуст ли список?
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return lastNode == null;
    }

    /**
     * Вставка
     *
     * @param object T
     */
    public void insert(T object) {
        Node<T> node = new Node<>(object); // создали узел
        node.previousNode = lastNode; // записали в новый узел ссылку на последний узел    {if (lastNode == null) n.previousNode = null;}
        lastNode = node; // сохраним ссылку на последний созданный узел
    }

    /**
     * Извлечение
     *
     * @return T
     */
    public T remove() {
        if (isEmpty()) return null;
        T result = lastNode.object; // получим ссылку на последний объект
        lastNode = lastNode.previousNode; // сохраним ссылку на последний узел
        return result; // вернем объект
    }

    /**
     * Содержит ли?
     *
     * @param object T
     * @return boolean
     */
    public boolean contains(T object) {
        Node<T> nodeObject = new Node<>(object);
        Node<T> nextNode = this.lastNode;
        while (!nextNode.equals(nodeObject)) { // выполнять пока следующий узел не равен объекту
            if (nextNode.previousNode == null) return false; // не содержит.
            else nextNode = nextNode.previousNode; // следующий узел
        }
        return true; // да, содержит.
    }

    /**
     * Извлечь объект по имени
     *
     * @param name String
     * @return T
     */
    public T delete(String name) {
        Node<T> nextNode = lastNode;
        Node<T> previous = lastNode;
        while (!(((Cat) nextNode.object).getName()).equals(name)) { // выполнять пока не найдено совпадение
            if (nextNode.previousNode == null) return null; // нечего извлекать.
            else {
                previous = nextNode;
                nextNode = nextNode.previousNode; // следующий узел
            }
        }
        // Свяжем списки после разрыва
        if (nextNode == lastNode)
            lastNode = lastNode.previousNode;
        else
            previous.previousNode = nextNode.previousNode;
        // Результат
        return nextNode.object;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        Node<T> nextNode = lastNode;
        StringBuilder result = new StringBuilder("[");
        while (nextNode != null) {
            result.append(nextNode);
            nextNode = nextNode.previousNode;
            result.append((nextNode == null) ? "]" : ", ");
        }
        return result.toString();
    }
}
