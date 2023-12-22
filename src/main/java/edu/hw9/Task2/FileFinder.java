package edu.hw9.Task2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileFinder extends RecursiveTask<List<Path>> {

    private final static Logger LOGGER = LogManager.getLogger();
    private final Path directoryPath;
    private final int fileSize;
    private final String fileExtension;

    public FileFinder(Path path, int fileSize, String fileExtension) {
        directoryPath = path;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }

    @Override
    protected List<Path> compute() {
        List<Path> pathsDirectories = new ArrayList<>();
        List<Path> pathsFiles = new ArrayList<>();
        try {
            for (var file : Files.newDirectoryStream(directoryPath)) {
                if (file.toFile().isDirectory()) {
                    pathsDirectories.add(file);
                } else {
                    String extension = getExtension(file.toFile());
                    if (file.toFile().length() < fileSize && extension != null && extension.equals(fileExtension)) {
                        pathsFiles.add(file);
                    }
                }

            }
            List<Path> specialFiles = new ArrayList<>(ForkJoinTask
                .invokeAll(
                    pathsDirectories.stream().map((path) -> new FileFinder(path, fileSize, fileExtension)).toList())
                .stream()
                .map(ForkJoinTask::join)
                .flatMap(List::stream)
                .toList());
            specialFiles.addAll(pathsFiles);
            return specialFiles;
        } catch (IOException e) {
            LOGGER.trace("Error: " + directoryPath);
        }
        return new ArrayList<>();
    }

    private static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }

        return ext;
    }
}
