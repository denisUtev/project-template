package edu.hw4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

public final class Task3 {

    private Task3() {

    }

    public static Map<Animal.Type, Integer> getMapOfCountTypeAnimal(Collection<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type, collectingAndThen(counting(), Long::intValue)));
    }
}
