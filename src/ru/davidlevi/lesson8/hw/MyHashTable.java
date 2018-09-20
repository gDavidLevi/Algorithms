package ru.davidlevi.lesson8.hw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * MyHashTable - реализация HashTable
 */
public class MyHashTable {
    /**
     * Элемент таблицы
     */
    static class Element {
        private int data;

        Element(int data) {
            this.data = data;
        }

        int getData() {
            return data;
        }
    }

    // -===============================================================================================================-
    private ArrayList<LinkedList<Element>> arrayLists = new ArrayList<>(); // массив связанных списоков

    /**
     * Конструктор
     *
     * @param size int
     */
    MyHashTable(int size) {
        for (int i = 0; i < size; i++)
            arrayLists.add(new LinkedList<>());
    }

    /**
     * Добавить в из таблицу
     *
     * @param element Element
     */
    public void insert(Element element) {
        int key = element.getData();
        int hash = hash(key);
        arrayLists.get(hash).add(element);
    }

    /**
     * Найти элемент в таблице
     *
     * @param key int
     * @return Element
     */
    Element find(int key) {
        int hash = hash(key);
        if (hash > arrayLists.get(hash).size())
            return new Element(-1);
        else
            return arrayLists.get(hash).get(hash);
    }

    /**
     * Удалить/извлечь из таблицы
     *
     * @param item Element
     * @return Element
     */
    public Element delete(Element item) {
        int hash = hash(item.getData());
        for (int i = 0; i < arrayLists.get(hash).size(); i++)
            if (arrayLists.get(hash).get(i).getData() == item.getData())
                return arrayLists.get(hash).remove(i);
        return new Element(-1);
    }

    /**
     * Возвращает hash значения
     *
     * @param value int
     * @return int
     */
    private int hash(int value) {
        return value % arrayLists.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<Element> items : arrayLists) {
            for (Element item : items)
                result.append(item.getData()).append(" ");
            result.append("\n");
        }
        return result.delete(result.length() - 2, result.length()).toString();
    }
}
