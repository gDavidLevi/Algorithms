package ru.davidlevi.lesson7.hw;


/**
 * Урок 7. Графы
 */
public class MainClass {
    public static void main(String[] args) {
        /*
         Домашняя работа № 7
            Задание:
                1. Реализовать программу, в которой задается граф из 10 вершин. Задать ребра и попробовать найти
                минимальный кратчайший путь с помощью поиска в ширину.
         */

        int size = 10;
        Graph graph = new Graph(size);
        for (int i = 0; i < size; i++)
            graph.addVertex(i);

        graph.addAdjacency(0, 1);
        graph.addAdjacency(1, 2);
        graph.addAdjacency(0, 3);
        graph.addAdjacency(3, 6);
        graph.addAdjacency(4, 7);
        graph.addAdjacency(4, 5);
        graph.addAdjacency(7, 8);
        graph.addAdjacency(6, 9);
        graph.addAdjacency(6, 7);
        graph.addAdjacency(5, 2);

        graph.inDepth();
        graph.broadwise(true, null);

        Graph.Vertex graphVertex = graph.getVertex(7);
        graph.showPath(graphVertex);
    }
}
