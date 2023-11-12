package edu.hw1;

public final class Task6 {

    private Task6() {
    }

    private static final int KAPREKAR_NUM = 6174;
    private static final int COUNT_FIGURES = 10;
    private static final int DISCHARGE = 10;
    private static final int MIN_NUMBER = 1001;
    private static final int MAX_NUMBER = 9999;

    @SuppressWarnings("ParameterAssignment")
    public static int countK(int num) {
        int[] countFigure = new int[COUNT_FIGURES];
        if (num < MIN_NUMBER || num > MAX_NUMBER) {
            throw new IllegalArgumentException("Необходимо четырехзначное число");
        }
        while (num > 0) {
            countFigure[num % COUNT_FIGURES]++;
            num /= DISCHARGE;
        }
        int newNum = getMaxNum(countFigure) - getMinNum(countFigure);
        if (newNum == 0) {
            throw new IllegalArgumentException("В числе не все цифры должны быть одинаковы");
        }
        if (newNum == KAPREKAR_NUM) {
            return 1;
        }
        return 1 + countK(newNum);
    }

    private static int getMinNum(int[] countFigure) {
        int num = 0;
        for (int i = 0; i < COUNT_FIGURES; i++) {
            for (int j = 0; j < countFigure[i]; j++) {
                num = num * DISCHARGE + i;
            }
        }
        return num;
    }

    private static int getMaxNum(int[] countFigure) {
        int num = 0;
        for (int i = COUNT_FIGURES - 1; i >= 0; i--) {
            for (int j = 0; j < countFigure[i]; j++) {
                num = num * DISCHARGE + i;
            }
        }
        return num;
    }
}
