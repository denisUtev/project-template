package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileCounter extends RecursiveTask<List<Path>> {

    private final static Logger LOGGER = LogManager.getLogger();
    private final Path directoryPath;
    private static final int REQUIRED_NUMBER_OF_FILES = 1000;

    public FileCounter(Path path) {
        directoryPath = path;
    }

    @Override
    protected List<Path> compute() {
        List<Path> pathsDirectories = new ArrayList<>();
        try {
            int countFiles = 0;
            for (var file : Files.newDirectoryStream(directoryPath)) {
                if (file.toFile().isDirectory()) {
                    pathsDirectories.add(file);
                }
                countFiles++;
            }
            List<Path> largeDirectories = new ArrayList<>(ForkJoinTask
                .invokeAll(
                    pathsDirectories.stream().map(FileCounter::new).toList())
                .stream()
                .map(ForkJoinTask::join)
                .flatMap(List::stream)
                .toList());
            if (countFiles >= REQUIRED_NUMBER_OF_FILES) {
                largeDirectories.add(directoryPath);
            }
            return largeDirectories;
        } catch (IOException e) {
            LOGGER.trace("Error: " + directoryPath);
            //System.out.println("Error: " + directoryPath);
        }
        return new ArrayList<>();
    }
}
