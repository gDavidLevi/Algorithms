package ru.davidlevi.lesson1;

public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 1
         */
        int[] arrayInteger = {13, 24, 35, 7, 14, 20, 54, -7, -15, 10, 31};
        System.out.println(SimplestAlgorithms.quickPow(2f, 6)); // 64.0
        System.out.println(SimplestAlgorithms.findMin(arrayInteger)); // -15
        System.out.println(SimplestAlgorithms.findMinRec(arrayInteger[arrayInteger.length - 1], arrayInteger, arrayInteger.length - 1)); // -15
        System.out.println(SimplestAlgorithms.average(arrayInteger)); // 16.90909
    }
}
