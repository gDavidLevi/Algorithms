package ru.davidlevi.lesson5.hw;

/**
 * Ханойская башня
 */
class HanoiTower {
    /**
     * @param numberOfDisks int
     * @param first         String
     * @param second        String
     * @param third         String
     */
    static void make(int numberOfDisks, String first, String second, String third) {
        if (numberOfDisks == 1)
            System.out.println("диск 1: с " + first + " на " + third);
        else {
            int dec = numberOfDisks - 1;
            make(dec, first, third, second);
            System.out.println("диск " + numberOfDisks + ": с " + first + " на " + third);
            make(dec, second, first, third);
        }
    }
}
