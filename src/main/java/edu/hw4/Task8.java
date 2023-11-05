package edu.hw4;

import java.util.Collection;
import java.util.Comparator;

public final class Task8 {

    private Task8() {

    }

    public static Animal getHeviestAnimalBelowK(Collection<Animal> animals, int k) {
        return animals.stream().filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::age)).get();
    }
}
