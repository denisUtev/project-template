package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static edu.hw6.Task3.Task3.FILTER;
import static java.nio.file.Files.newDirectoryStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {

    public static final String DATA_PATH = "src/test/java/edu/hw6";

    @Test
    @DisplayName("тест цепочечного фильтра")
    void testFILTER() {
        Path rightPath = Path.of("src\\test\\java\\edu\\hw6\\Снимок экрана 2023-10-19 135343.png");
        try {
            assertThat(newDirectoryStream(Path.of(DATA_PATH), FILTER).iterator().next())
                .isEqualTo(rightPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
