package edu.hw6.Task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

public final class Task4 {

    private Task4() {

    }

    public static void compositionWriteFile(String path) {
        try (var outputStream = Files.newOutputStream(Path.of(path));
             var checkedOutputStream = new CheckedOutputStream(outputStream, new Adler32());
             var bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             var outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, StandardCharsets.UTF_8);
             var printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println("Programming is learned by writing programs. ― Brian Kernighan");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
