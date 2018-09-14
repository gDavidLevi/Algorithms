package ru.davidlevi.lesson6.hw;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Урок 6. Деревья
 */
public class MainClass {
    /**
     * Возвращает случайное число из диапазаона [a,b]
     *
     * @param min int
     * @param max int
     * @return int
     */
    private static int getRandomInt(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void main(String[] args) {
         /*
         Домашняя работа № 6
            Задание:
                1. Создать программу для построения двоичного дерева. В цикле построить несколько деревьев. Данные,
                которыми необходимо заполнить узлы деревьев представляются в виде чисел типа int. Число, которое
                попадает в узел, должно генерироваться случайным образом в диапазоне от -100 до 100.
                2. Проанализировать, какой процент созданных деревьев является несбалансированными.
         */

        int quantityTrees = 4; // количество деревьев
        int quantityElements = 6; // количество узлов в дереве

        // Сожаем лес
        List<Tree> forest = new ArrayList<>();
        for (int t = 0; t < quantityTrees; t++) {
            Tree tree = new Tree();
            for (int elem = 0; elem < quantityElements; elem++)
                tree.insert(new Cat(getRandomInt(-100, 100)));
            forest.add(tree);
        }

        // Показываем лес
        for (Tree tree : forest) {
            tree.displayTree();
            System.out.println();
        }

        // Баланс
        int counter = 0;
        int forestSize = forest.size();
        for (int i = 0; i < forestSize; i++)
            if (forest.get(i).isBalanced())
                counter++; // да
            else
                counter += 0;
        int result = counter * 100 / forestSize;
        System.out.println("Процент созданных деревьев является несбалансированными, %: " + result);
    }
}
