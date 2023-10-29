package edu.hw3;

public final class Task1 {

    private Task1() {
    }

    private static final int FIRST_LOWER_LATIN_LETTER = 'a';
    private static final int LAST_LOWER_LATIN_LETTER = 'z';
    private static final int FIRST_UPPER_LATIN_LETTER = 'A';
    private static final int COUNT_LATIN_LETTERS = 26;

    public static String encodeAtbash(String text) {
        StringBuilder resultText = new StringBuilder();
        for(int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= FIRST_UPPER_LATIN_LETTER && text.charAt(i) <= LAST_LOWER_LATIN_LETTER) {
                resultText.append(getAtbashLetter(text.charAt(i)));
            } else {
                resultText.append(text.charAt(i));
            }
        }
        return resultText.toString();
    }

    private static char getAtbashLetter(char a) {
        if (a < FIRST_UPPER_LATIN_LETTER || a > LAST_LOWER_LATIN_LETTER) {
            throw new IllegalArgumentException();
        }
        if (a >= FIRST_LOWER_LATIN_LETTER) {
            return (char) ((FIRST_LOWER_LATIN_LETTER + COUNT_LATIN_LETTERS / 2) - (a - (FIRST_LOWER_LATIN_LETTER + COUNT_LATIN_LETTERS / 2)) - 1);
        }
        return (char) ((FIRST_UPPER_LATIN_LETTER + COUNT_LATIN_LETTERS / 2) - (a - (FIRST_UPPER_LATIN_LETTER + COUNT_LATIN_LETTERS / 2)) - 1);
    }
}
