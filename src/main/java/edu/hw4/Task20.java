package edu.hw4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class Task20 {

    private Task20() {

    }

    public static Map<String, String> getMapErrors(Collection<Animal> animals) {
        return animals.stream().map(a -> {
            List<String> errors = new ArrayList<>();
            if (a.age() < 0) {
                errors.add("age");
            }
            if (a.weight() < 0) {
                errors.add("weight");
            }
            if (a.height() < 0) {
                errors.add("height");
            }
            return Map.entry(a.name(), String.join(", ", errors));
        }).filter(a -> !a.getValue().isEmpty()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
