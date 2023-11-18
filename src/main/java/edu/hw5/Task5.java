package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task5 {

    private Task5() {

    }

    public static boolean isValidNumberMark(String numberMark) {
        Pattern numberMarkPattern = Pattern.compile("^[А-Я]\\d{3}[А-Я]{2}\\d{3}$");
        Matcher matcher = numberMarkPattern.matcher(numberMark);
        return matcher.find();
    }
}
