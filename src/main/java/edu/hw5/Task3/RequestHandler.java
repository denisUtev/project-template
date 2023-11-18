package edu.hw5.Task3;

import java.time.LocalDate;

public interface RequestHandler {

    boolean canHandleRequest(String stroke);

    LocalDate handle(String stroke);
}
