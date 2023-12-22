package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class Task5 {

    private Task5() {

    }

    public static Animal.Sex getMostPopularSex(Collection<Animal> animals) {
        var mapOfAnimals =  animals.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));
        return mapOfAnimals.entrySet().stream()
            .max(Comparator.comparingInt(entry -> entry.getValue().intValue())).get().getKey();
    }
}
