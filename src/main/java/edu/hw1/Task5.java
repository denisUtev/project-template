package edu.hw1;

public final class Task5 {

    private Task5() {
    }

    private static final int MIN_DESCENDANT = 11;
    private static final int DISCHARGE = 10;
    private static final int DOUBLE_DISCHARGE = 100;

    public static boolean isPalindromeDescendant(int num) {
        int lastDescendant = num;
        int descendant = num;
        int step = 0;
        while (descendant >= MIN_DESCENDANT) {
            if (isPalindrom(descendant)) {
                return true;
            }
            descendant = 0;
            step = 0;
            while (lastDescendant > 0) {
                descendant += (int) (Math.pow(DISCHARGE, step)
                        * (lastDescendant % DISCHARGE + (lastDescendant % DOUBLE_DISCHARGE) / DISCHARGE));
                lastDescendant /= DOUBLE_DISCHARGE;
                step++;
            }
            lastDescendant = descendant;
        }
        return false;
    }

    private static boolean isPalindrom(int num) {
        int reversedNum = 0;
        int a = num;
        while (a > 0) {
            reversedNum = reversedNum * DISCHARGE + a % DISCHARGE;
            a /= DISCHARGE;
        }
        return reversedNum == num;
    }
}
