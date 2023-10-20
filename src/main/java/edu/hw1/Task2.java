package edu.hw1;

public final class Task2 {

    private Task2() {
    }

    private static final int DISCHARGE = 10;

    @SuppressWarnings("ParameterAssignment")
    public static int countDigits(int num) {
        int count = 0;
        do {
            num /= DISCHARGE;
            count++;
        } while (num != 0);
        return count;
    }
}
