package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class StandartDictionary implements Dictionary {

    private final String[] words = new String[]{"denis", "utev", "java", "python", "ruby", "processing"};
    Random randomIndex = new Random();

    @Override
    public @NotNull String randomWord() {
        return words[randomIndex.nextInt(words.length)];
    }
}
