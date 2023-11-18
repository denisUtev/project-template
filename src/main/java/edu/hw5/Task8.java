package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task8 {

    private Task8() {

    }

    public static boolean isNotEvenNumbered(String text) {
        Pattern numberMarkPattern = Pattern.compile("^[01](00|01|10|11)*$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }

    public static boolean isEvenNumberedOrNot(String text) {
        Pattern numberMarkPattern = Pattern.compile("^0(00|01|10|11)*$|^1[01](00|01|10|11)*$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }

    public static boolean isCountZeroDivided3(String text) {
        Pattern numberMarkPattern = Pattern.compile("^(1*01*01*01*)*$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }

    public static boolean isAllNotEvenNumberedIsOne(String text) {
        Pattern numberMarkPattern = Pattern.compile("^(1[01])*1?$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }
}
