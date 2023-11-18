package edu.hw5.Task3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Task3 {

    private Task3() {

    }

    public static final List<RequestHandler> HANDLERS = new ArrayList<>() {{
        add(new DateParseHandler());
        add(new NearDayParseHandler());
        add(new NDaysAgoParseNadler());
    }};

    public static Optional<LocalDate> parseDate(String stroke) {
        return HANDLERS.stream()
            .filter(handler -> handler.canHandleRequest(stroke))
            .map(handler -> handler.handle(stroke)).findFirst();
    }
}
