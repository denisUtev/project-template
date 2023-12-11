package edu.hw9;

import edu.hw9.Task2.ForkJoinFileCounter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.util.List;

public class Task2Test {

    private static final Path ROOT_PATH1 = Path.of("C:\\");
    //private static final Path ROOT_PATH2 = Path.of("C:\\Users\\utev2\\OneDrive\\Рабочий стол\\Новый Разум\\память");

    @Test
    @DisplayName("тест поисковика файлов, содержащих более 1000 файлов")
    void testFileCounterLargeFiles() {
        List<Path> pathsLagreDirs = ForkJoinFileCounter.getLargePaths(ROOT_PATH1);
        System.out.println("\nLarge Files:\n");
        for (var dir : pathsLagreDirs) {
            System.out.println(dir);
        }
    }

    @Test
    @DisplayName("тест поисковика файлов, имеющих нужное расширение и нужный размер (меньше указанного)")
    void testFileFinder() {
        List<Path> pathsSpecialFiles = ForkJoinFileCounter.getSpecialFiles(ROOT_PATH1, 18 * 1024, "txt");
        System.out.println("\nSpecial Files:\n");
        for (var file : pathsSpecialFiles) {
            System.out.println(file);
        }
    }
}
