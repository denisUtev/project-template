package edu.hw5.Task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParseHandler implements RequestHandler {

    private final static Map<String, String> MAP_REGEX_FOR_DATES = new HashMap<>() {{
        put("^\\d\\d\\d\\d-\\d\\d-\\d\\d$", "yyyy-MM-dd"); // 2010-10-10
        put("^\\d\\d\\d\\d-\\d\\d-\\d$", "yyyy-MM-d"); // 2010-10-2
        put("^\\d\\d\\d\\d-\\d-\\d$", "yyyy-M-d"); // 2010-9-2
        put("^\\d\\d\\d\\d-\\d-\\d\\d$", "yyyy-M-dd"); // 2010-9-20

        put("^\\d/\\d/\\d\\d\\d\\d$", "d/M/yyyy"); // 1/3/1976
        put("^\\d\\d/\\d/\\d\\d\\d\\d$", "dd/M/yyyy"); // 11/3/1976
        put("^\\d/\\d\\d/\\d\\d\\d\\d$", "d/MM/yyyy"); // 11/3/1976
        put("^\\d\\d/\\d\\d/\\d\\d\\d\\d$", "dd/MM/yyyy"); // 11/3/1976

        put("^\\d/\\d/\\d\\d$", "d/M/yy"); // 1/3/20
        put("^\\d\\d/\\d/\\d\\d$", "dd/M/yy"); // 11/3/20
        put("^\\d/\\d\\d/\\d\\d$", "d/MM/yy"); // 11/3/20
        put("^\\d\\d/\\d\\d/\\d\\d$", "dd/MM/yy"); // 11/3/20
    }};

    @Override
    public boolean canHandleRequest(String stroke) {
        for (var key : MAP_REGEX_FOR_DATES.keySet()) {
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(stroke);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LocalDate handle(String stroke) {
        for (var key : MAP_REGEX_FOR_DATES.keySet()) {
            var formatter = DateTimeFormatter.ofPattern(MAP_REGEX_FOR_DATES.get(key));
            Pattern pattern = Pattern.compile(key);
            Matcher matcher = pattern.matcher(stroke);
            if (matcher.find()) {
                return LocalDate.parse(matcher.group(0), formatter);
            }
        }
        return null;
    }
}
