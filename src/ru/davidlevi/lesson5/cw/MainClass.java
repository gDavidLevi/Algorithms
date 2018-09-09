package ru.davidlevi.lesson5.cw;

/**
 * Урок 5. Рекурсия
 */
public class MainClass {
    // Размер матрицы
    private static int nRows = 8;
    private static int nColumns = 8;
    // Доска
    private static int[][] board = new int[nColumns][nRows];
    // Счетчик считает сколько раз вызывалась рекурсивная функция routes()
    private static int count = 0;

    /**
     * Выводит числа последовательно от i до нуля
     *
     * @param i int
     */
    private static void iteratorPrint(int i) {
        while (i >= 0)
            System.out.print(i-- + " ");
        System.out.println();
    }

    /**
     * Возвращает минимальный элемент в массиве (рекурсивно)
     *
     * @param array int[] массив
     * @param size  int размер
     * @return int
     */
    private static int recursivelyMinimum(int[] array, int size) {
        if (size > 0) return Math.min(array[size - 1], recursivelyMinimum(array, size - 1));
        else return array[size];
    }

    /**
     * Выводит числа последовательно от i до нуля (рекурсивно)
     *
     * @param i int
     */
    private static void recursivelyPrint(int i) {
        if (i >= 0) { // если >= 0, то...
            System.out.print(i + " "); // данная строка - это полезная нагрузка
            //... вызываем этот же метод, но уже меньшим количеством i до i >= 0
            recursivelyPrint(--i); // примечание: это хвостовая рекурсия потому, что она находится после полезной нагрузки
        }
    }

    /**
     * Возвращает количество маршрутор до точки [row,column]
     * <p>
     * Сколько возможных маршрутов будет у фигуры, чтобы прийти в точку [row,column]?
     * Ответ: R(row-1,column) + R(row,column-1)
     *
     * @param row    int
     * @param column int
     * @return int
     */
    private static int routes(int row, int column) {
        count++;
        if (row == 0 && column == 0)
            return 0; // если (row&column)=0, то коричество маршрутор будет равно нулю R(row,column)=0
        if (row == 0 || column == 0)
            return 1; // если (row|column)=0, то коричество маршрутор будет равно нулю R(row,column)=1
        return routes(row - 1, column) + routes(row, column - 1); // рекурсия
    }

    /**
     * Метод заполняем матрицу нулями
     */
    private static void initBoard() {
        for (int row = 0; row < nColumns; row++)
            for (int column = 0; column < nRows; column++)
                board[row][column] = 0;
    }

    /**
     * Проверка королевы
     *
     * @param x
     * @param y
     * @return boolean
     */
    private static boolean checkQueen(int x, int y) {
        for (int row = 0; row < nColumns; row++) {
            for (int column = 0; column < nRows; column++) {
                if (board[row][column] != 0)
                    if (!(row == x && column == y)) {
                        if (row - x == 0 || column - y == 0) return false;
                        if (Math.abs(row - x) == Math.abs(column - y)) return false;
                    }
            }
        }
        return true;
    }

    /**
     * Возвращает true если доска проверена
     *
     * @return boolean
     */
    private static boolean checkBoard() {
        for (int row = 0; row < nColumns; row++) {
            for (int column = 0; column < nRows; column++) {
                if (board[row][column] != 0)
                    if (!checkQueen(row, column))
                        return false;
            }
        }
        return true;
    }

    /**
     * Метод queensWereInstalled() возвращет true, если получилось установить number фигур
     *
     * @param number int число фигур
     * @return boolean
     */
    private static boolean queensWereInstalled(int number) {
        int QUEENS = 8; // размер доски
        if (!checkBoard()) return false;
        if (number == QUEENS + 1) return true;
        for (int row = 0; row < nColumns; row++) {
            for (int column = 0; column < nRows; column++) {
                if (board[row][column] == 0) {
                    board[row][column] = number;
                    if (queensWereInstalled(number + 1)) return true;
                    board[row][column] = 0;
                }
            }
        }
        return false;
    }

    /**
     * Вывод доски
     */
    private static void printBoard() {
        for (int row = 0; row < nColumns; row++) {
            for (int column = 0; column < nRows; column++)
                System.out.print(board[row][column] + " ");
            System.out.println();
        }
    }

    // Точка входа
    public static void main(String[] args) {
        // Вывод нерекурсивный
        iteratorPrint(5); // 5 4 3 2 1 0

        // Вывод рекурсивный
        recursivelyPrint(5); // 5 4 3 2 1 0
        System.out.println();

        // --------------------------------------------------------------------------
        int[] arr = {1, 2, 7, 6, 5, 4, 3, 2, -5, 3, 4, 5, 6};
        System.out.println(recursivelyMinimum(arr, arr.length)); // -5

        // --------------------------------------------------------------------------
        /*
          Имеется шахматная достка [row,column], имеется фигура (королева), которая умеет ходить вправа и вниз.
          Фигура на шахматной доске стоит в позиции [0,0].
          1. Сколько возможных маршрутов будет у фигуры, чтобы прийти в точку [0,column]?
          Ответ: 1 маршрут, то есть R(row,column)=1, если (row^column)=0
          2. Сколько возможных маршрутов будет у фигуры, чтобы прийти в точку [row,column]?
          Ответ: R(row-1,column) + R(row,column-1)
         */
        System.out.println("Все маршруты до точки [10,10]:");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("%7d", routes(i, j));
            }
            System.out.println();
        }
        System.out.println("Счетчик считает сколько раз вызывалась рекурсивная функция routes(): " + count); // 369410

        // --------------------------------------------------------------------------
        initBoard();
        queensWereInstalled(1);
        printBoard();
        /*
        1 0 0 0 0 0 0 0
        0 0 0 0 2 0 0 0
        0 0 0 0 0 0 0 3
        0 0 0 0 0 4 0 0
        0 0 5 0 0 0 0 0
        0 0 0 0 0 0 6 0
        0 7 0 0 0 0 0 0
        0 0 0 8 0 0 0 0
        */
    }
}
