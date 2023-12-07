package edu.hw6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.FileNotFoundException;

public final class Task2 {

    private Task2() {

    }

    public static void cloneFile(Path path) {
        try {
            String newFileName = getNewFileName(path.getFileName().toString());
            Path newPath = Path.of(path.getParent() + "/" + newFileName);
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(newPath.toFile()));

            while (reader.ready()) {
                writer.write(reader.read());
            }
            reader.close();
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {

        }
    }

    public static String getNewFileName(String fileName) {
        String extension = fileName.substring(fileName.indexOf('.'));
        String name = fileName.substring(0, fileName.indexOf('.'));
        String newName = "";

        Pattern copiedFilePattern = Pattern.compile("копия \\(\\d*\\)");
        Matcher fileNameMatcher = copiedFilePattern.matcher(name);
        if (fileNameMatcher.find() && fileNameMatcher.end() == name.length()) {
            String endName = fileNameMatcher.group();
            int startNumber = endName.indexOf('(') + 1;
            int endNumber = endName.indexOf(')');
            int number = Integer.parseInt(endName.substring(startNumber, endNumber)) + 1;
            newName = name.substring(0, fileNameMatcher.start()) + String.format("копия (%d)", number);
            return newName + extension;
        }

        copiedFilePattern = Pattern.compile("копия");
        fileNameMatcher = copiedFilePattern.matcher(name);
        if (fileNameMatcher.find() && fileNameMatcher.end() == name.length()) {
            newName = name + " (2)";
            return newName + extension;
        }

        newName = name + " — копия";
        return newName + extension;
    }
}
