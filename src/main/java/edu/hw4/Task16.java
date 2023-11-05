package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public final class Task16 {

    private Task16() {

    }

    public static List<Animal> getSortedAnimalsByTypeSexName(Collection<Animal> animals) {
        //не правильно работает, потом переделаю
        return animals.stream().sorted(Comparator.comparingInt(a -> a.type().ordinal()))
            .sorted(Comparator.comparingInt(a -> a.sex().ordinal()))
            .sorted(Comparator.comparing(Animal::name)).toList();
    }
}
