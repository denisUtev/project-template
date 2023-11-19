package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    public static final String FILE_PATH = "src/test/java/edu/hw6/diskMapData.txt";
    public static final String COPIED_FILE_PATH = "src/test/java/edu/hw6/diskMapData — копия.txt";

    @Test
    @DisplayName("тест преобразования имени для копии файла")
    void testGetCopiedFileName() {
        String name = "Tinkoff Bank Biggest Secret.txt";
        String copy = Task2.getNewFileName(name);
        assertThat(copy).isEqualTo("Tinkoff Bank Biggest Secret — копия.txt");

        String copy2 = Task2.getNewFileName(copy);
        assertThat(copy2).isEqualTo("Tinkoff Bank Biggest Secret — копия (2).txt");

        String copy3 = Task2.getNewFileName(copy2);
        assertThat(copy3).isEqualTo("Tinkoff Bank Biggest Secret — копия (3).txt");
    }

    @Test
    @DisplayName("тест копирования файла")
    void testCloneFile() {
        Path filePath = Path.of(FILE_PATH);
        Task2.cloneFile(filePath);
        assertThat(Files.exists(Path.of(COPIED_FILE_PATH))).isEqualTo(true);
    }
}
