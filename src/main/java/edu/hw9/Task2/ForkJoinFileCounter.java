package edu.hw9.Task2;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public final class ForkJoinFileCounter {

    private ForkJoinFileCounter() {

    }

    public static List<Path> getLargePaths(Path rootPath) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new FileCounter(rootPath));
    }

    public static List<Path> getSpecialFiles(Path rootPath, int size, String extension) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new FileFinder(rootPath, size, extension));
    }
}
