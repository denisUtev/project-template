package edu.hw6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.File;
import static edu.hw6.Task4.Task4.CompositionWriteFile;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {

    public final String PATH_FILE = "src/main/java/edu/hw6/Task4/test.txt";

    @Test
    @DisplayName("тест работы композиции OutputStream-ов")
    void testFILTER() {
        if (new File(PATH_FILE).exists()) {
            new File(PATH_FILE).delete();
        }
        CompositionWriteFile(PATH_FILE);
        assertThat(new File(PATH_FILE).exists()).isEqualTo(true);
    }
}
