package ru.davidlevi.lesson4.hw_alternate;

import ru.davidlevi.lesson4.cw.Cat;

public class MainClass {
    public static void main(String[] args) {
        DoubleRelatedListAlt list = new DoubleRelatedListAlt();
        System.out.println(list);
        list.push(new Cat(1, "cat1"));
        list.push(new Cat(1, "cat2"));
        list.push(new Cat(1, "cat3"));
        System.out.println(list);
        list.pop();
        System.out.println(list);
        list.pop();
        System.out.println(list);
        list.deleteCurrent();
        System.out.println(list);
        list.push(new Cat(1, "cat4"));
        System.out.println(list);
        list.delete(new Cat(1, "cat4"));
        System.out.println(list);
    }
}
