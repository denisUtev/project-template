package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import static edu.hw6.Task3.AbstractFilter.globMatches;
import static edu.hw6.Task3.AbstractFilter.largerThan;
import static edu.hw6.Task3.AbstractFilter.magicNumber;
import static edu.hw6.Task3.AbstractFilter.regexContains;

public final class Task3 {

    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;

    private static final int MUST_SIZE = 100_000;
    private static final int PNG_NUMBER = 0x89;

    public static final DirectoryStream.Filter<Path> FILTER = REGULAR_FILE
        .and(READABLE)
        .and(largerThan(MUST_SIZE))
        .and(magicNumber(PNG_NUMBER, 'P', 'N', 'G'))
        .and(globMatches("*.png"))
        .and(regexContains("[-]"));

    private Task3() {

    }
}
