package edu.hw4;

import java.util.Collection;
import java.util.List;

public final class Task2 {

    private Task2() {

    }

    public static List<Animal> getListOfHeaviestAnimals(Collection<Animal> animals, int k) {
        return animals.stream().sorted((a, b) -> b.weight() - a.weight()).limit(k).toList();
    }
}
