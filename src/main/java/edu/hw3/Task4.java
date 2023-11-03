package edu.hw3;

import java.util.HashMap;

public final class Task4 {

    private Task4() {

    }

    @SuppressWarnings("MagicNumber")
    private static final HashMap<Integer, String> ROMAN_NUMERAL = new HashMap<>() {{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};
    private static final int[] ROMAN_VALUES = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    @SuppressWarnings("ParameterAssignment")
    public static String convertToRoman(int num) {
        StringBuilder romanNumber = new StringBuilder();

        while (num > 0) {
            for (int value : ROMAN_VALUES) {
                while (num >= value) {
                    romanNumber.append(ROMAN_NUMERAL.get(value));
                    num -= value;
                }
            }
        }

        return romanNumber.toString();
    }
}
