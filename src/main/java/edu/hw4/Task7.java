package edu.hw4;

import java.util.Collection;
import java.util.Comparator;

public final class Task7 {

    private Task7() {

    }

    public static Animal getOldestAnimal(Collection<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::age)).skip(animals.size() - k).findFirst().get();
    }
}
