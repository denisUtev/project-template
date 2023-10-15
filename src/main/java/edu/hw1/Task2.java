package edu.hw1;

public final class Task2 {

    private Task2() {
    }

    private static final int DISCHARGE = 10;

    public static int countDigits(int num) {
        int count = 0;
        int a = num;
        do {
            a /= DISCHARGE;
            count++;
        } while (a > 0);

        return count;
    }
}
