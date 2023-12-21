package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class NearDayParseHandler implements RequestHandler {

    private static final Map<String, Integer> HANDLES = new HashMap<>() {{
        put("tomorrow", 1);
        put("today", 0);
        put("yesterday", -1);
    }};

    @Override
    public boolean canHandleRequest(String stroke) {
        for (var handle : HANDLES.keySet()) {
            if (stroke.contains(handle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public LocalDate handle(String stroke) {
        return LocalDate.now().plusDays(HANDLES.get(stroke));
    }
}
