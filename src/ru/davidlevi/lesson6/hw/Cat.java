package ru.davidlevi.lesson6.hw;

/**
 * Котик
 */
public class Cat {
    private static int uid = 0; // уникальный uid
    String name;
    int age;
    int id;

    public Cat(int age) {
        this.name = null;
        this.age = age;
        id = uid++;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        id = uid++;
    }
}
