package ru.davidlevi.lesson6.cw;

/**
 * Урок 6. Деревья
 */
public class MainClass {

    // n^k = n^k-1 * n
    private static int power(int base, int sign) {
        return (sign == 0) ? 1 : power(base, sign - 1) * base;
    }

    private static int operations = 0;

    static void put(int from, int to) {
        System.out.printf("%d -> %d | ", from, to);
        if (++operations % 10 == 0) System.out.print('\n');
    }

    private static void tower(int height, int from, int to) {
        int temp = from ^ to; // 1^2=3; 1^3=2; 2^3=1
        if (height == 1) {
            put(from, to);
        } else {
            tower(height - 1, from, temp);
            put(from, to);
            tower(height - 1, temp, to);
        }
    }

    private static int[][] kMoves = {
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
    };

    private static boolean isPossible(int[][] desk, int x, int y) {
        return x >= 0 && x < desk.length &&
                y >= 0 && y < desk[0].length &&
                desk[x][y] == 0;
    }

    private static boolean knightMove(int[][] desk, int currX, int currY, int move) {
        int nextX, nextY;
        desk[currX][currY] = move;
        if (move > (desk.length * desk[0].length) - 1) return true;

        for (int i = 0; i < 8; i++) {
            nextX = currX + kMoves[i][1];
            nextY = currY + kMoves[i][0];
            if (isPossible(desk, nextX, nextY) &&
                    knightMove(desk, nextX, nextY, move + 1))
                return true;
        }

        desk[currX][currY] = 0;
        return false;
    }

    private static void printDesk(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[0].length; j++) {
                System.out.printf("%3d", desk[i][j]);
            }
            System.out.println();
        }
    }

//    Sack relations
//    m[0, w] = 0;
//    m[i, w] = m[i-1, w], если w[i] > w;
//    m[i, w] = max(m[i - 1, w], m[i - 1, w - w[i]] + v[i]), если w[i] ≤ w;

    public static void main(String[] args) {
        System.out.println(power(2, 10));

        tower(8, 1, 3);
        System.out.println("\n" + operations);

        int[][] desk = new int[8][8];
        knightMove(desk, 1, 0, 1);
        printDesk(desk);
    }
}