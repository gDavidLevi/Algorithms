package ru.davidlevi.lesson4.hw_alternate;

import ru.davidlevi.lesson4.cw.Cat;

public class MainClass {
    /**
     * @param arr  int[]
     * @param size int
     * @return int
     */
    private static int linear(int[] arr, int size) {
        if (size > 0) return Math.min(arr[size - 1], linear(arr, size - 1));
        else return arr[size];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 7, 6, 5, 4, 3, 2, -5, 3, 4, 5, 6};
        System.out.println(linear(arr, arr.length));

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
