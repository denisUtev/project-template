package edu.hw1;

public final class Task4 {

    private Task4() {
    }

    public static String fixString(String stroke) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < stroke.length(); i += 2) {
            if (i + 1 < stroke.length()) {
                result.append(stroke.charAt(i + 1));
            }
            result.append(stroke.charAt(i));
        }

        return result.toString();
    }
}
