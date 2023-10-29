package edu.hw3;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class Task3 {

    private Task3() {

    }

    public static <T> Map<T, Integer> freqDict(T[] list) {
        HashMap<T, Integer> dict = new HashMap<>();

        for(T word : list) {
            if (dict.containsKey(word)) {
                dict.put(word, dict.get(word) + 1);
            } else {
                dict.put(word, 1);
            }
        }

        return dict;
    }
}
