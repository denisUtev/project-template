package edu.hw5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task6 {

    private Task6() {

    }

    private static final String REGEX_SYMBOLS = "[{(*.+?^$";

    @SuppressWarnings("ParameterAssignment")
    public static boolean isSubstring(String stroke, String substringInText) {
        for (int i = 0; i < REGEX_SYMBOLS.length(); i++) {
            Pattern regexPattern = Pattern.compile(String.format("\\%s", REGEX_SYMBOLS.charAt(i)));
            Matcher regexMatcher = regexPattern.matcher(substringInText);
            while (regexMatcher.find()) {
                substringInText = substringInText.replace(
                    regexMatcher.group(), "\\" + regexMatcher.group());
            }
        }
        Pattern substringPattern = Pattern.compile(substringInText);
        Matcher matcher = substringPattern.matcher(stroke);
        return matcher.find();
    }
}
