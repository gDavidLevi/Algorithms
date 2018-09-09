package ru.davidlevi.lesson5.hw;

/**
 * Задача о шахматном коне
 */
class ChessKnight {
    // Размер доски
    private static final int boardSize = 8;
    // Все возможные позиции для текущей клетки удобно записать:
    private static int[] dRows = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] dColumns = {2, 1, -1, -2, -2, -1, 1, 2};

    /**
     * Метод возвращает true если конь внутри доски
     *
     * @param inRow    в строке
     * @param inColumn с колонке
     * @return boolean
     */
    private static boolean inside(int inRow, int inColumn) {
        return (inRow >= 0 && inRow < boardSize && inColumn >= 0 && inColumn < boardSize);
    }

    /**
     * Вероятность
     * <p>
     * Идея заключается в том, чтобы при каждом i-ом ходе отслеживать вероятность того, что конь окажется
     * в определенной клетке.
     *
     * @param startRow      int
     * @param startColumn   int
     * @param numberOfSteps число шагов
     * @return double
     */
    static double probability(int startRow, int startColumn, int numberOfSteps) {
        double[][][] result = new double[boardSize][boardSize][boardSize];
        // Инициализация
        for (int row = 0; row < boardSize; ++row)
            for (int column = 0; column < boardSize; ++column)
                result[row][column][0] = 1;
        // Ради каждого числа шагов
        for (int step = 1; step <= numberOfSteps; ++step) {
            // Ради каждой позиции после step-числа шагов
            for (int x = 0; x < boardSize; ++x) {
                for (int y = 0; y < boardSize; ++y) {
                    double currentProbability = 0.0;
                    // Ради каждой достижимой позиции от (строка, столбец)
                    for (int i = 0; i < boardSize; ++i) {
                        int row = x + dRows[i];
                        int column = y + dColumns[i];
                        // Если данная позиция находится внутри шахматного поля
                        if (inside(row, column))
                            currentProbability += result[row][column][step - 1] / (double) boardSize;
                    }
                    result[x][y][step] = currentProbability; // созранить результат
                }
            }
        }
        return result[startRow][startColumn][numberOfSteps];
    }
}
