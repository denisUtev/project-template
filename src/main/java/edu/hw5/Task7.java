package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task7 {

    private Task7() {

    }

    public static boolean isValid1(String text) {
        Pattern numberMarkPattern = Pattern.compile("^.{2}0.*$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }

    public static boolean isValid2(String text) {
        Pattern numberMarkPattern = Pattern.compile("^0.*0$|^1.*1$|^0$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }

    public static boolean isValid3(String text) {
        Pattern numberMarkPattern = Pattern.compile("^[01]{1,3}$");
        Matcher matcher = numberMarkPattern.matcher(text);
        return matcher.find();
    }
}
