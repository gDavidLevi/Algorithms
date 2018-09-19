package ru.davidlevi.lesson8.cw;

import java.util.Objects;

public class Item {
    private int data;

    public Item(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return data == item.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
