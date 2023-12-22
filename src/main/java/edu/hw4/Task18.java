package edu.hw4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public final class Task18 {

    private Task18() {

    }

    public static Animal getHeviestFIsh(Collection<Animal>... animals) {
        return Arrays.stream(animals)
            .flatMap(Collection::stream)
            .filter(a -> a.type().equals(Animal.Type.FISH))
            .max(Comparator.comparingInt(Animal::weight)).orElse(null);
    }
}
