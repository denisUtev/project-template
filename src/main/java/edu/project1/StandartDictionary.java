package edu.project1;

import org.jetbrains.annotations.NotNull;
import java.util.Random;

public class StandartDictionary implements Dictionary{

    private String[] words = new String[]{"Denis", "Utev", "Java", "Python", "Ruby", "Processing"};
    @Override
    public @NotNull String randomWord() {
        Random randomIndex = new Random();
        return words[randomIndex.nextInt(words.length)];
    }
}
