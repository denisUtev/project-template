package edu.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task6 {

    private Task6() {

    }

    public static Map<Animal.Type, Animal> getMapOfHeaviestAnimals(Collection<Animal> animals) {
        var mapOfTypeAnimals = animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.toSet()));
        return mapOfTypeAnimals.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
            b -> b.getValue().stream().max(Comparator.comparingInt(Animal::weight)).get()));
    }
}
