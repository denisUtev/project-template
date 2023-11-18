package edu.hw5.Task3;

import java.time.LocalDate;

public class NDaysAgoParseNadler implements RequestHandler {

    private static final String[] HANDLES = new String[]{"day ago", "days ago"};

    @Override
    public boolean canHandleRequest(String stroke) {
        for (var handle : HANDLES) {
            if (stroke.contains(handle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LocalDate handle(String stroke) {
        return LocalDate.now().minusDays(
                Integer.parseInt(stroke.substring(0, stroke.indexOf(' '))));
    }
}
