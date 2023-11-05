package edu.hw4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task3 {

    private Task3() {

    }

    public static Map<Animal.Type, Integer> getMapOfCountTypeAnimal(Collection<Animal> animals) {
        Map<Animal.Type, Integer> result = new HashMap<>();
        animals.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()))
            .forEach((type, count) -> result.put(type, count.intValue()));
        return result;
    }
}
