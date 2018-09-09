package ru.davidlevi.lesson4.hw_alternate;

import java.util.Iterator;

/**
 * MyIteratorAlt интерфейс-переборщик
 *
 * @param <T>
 */
public interface MyIteratorAlt<T> extends Iterator {
    void reset();

    boolean atEnd();

    boolean atBegin();

    T deleteCurrent();

    void insertAfter(T c);

    void insertBefore(T c);

    T getCurrent();
}
