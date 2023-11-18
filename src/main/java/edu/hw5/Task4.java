package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task4 {

    private Task4() {

    }

    public static boolean isCorrectPassword(String textPassword) {
        Pattern pattern = Pattern.compile(".*[~!@#$%^&*|].*");
        Matcher matcher = pattern.matcher(textPassword);
        return matcher.find();
    }
}
