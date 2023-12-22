package edu.hw4;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Task15 {

    private Task15() {

    }

    public static Map<Animal.Type, Integer>
    getMapSumWeightOfTypeAnimalsFromKToLYears(Collection<Animal> animals, int k, int l) {
        var result = animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() < l).collect(
                Collectors.groupingBy(Animal::type, Collectors.toList())
            ).entrySet().stream().collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    set -> set.getValue().stream().flatMapToInt(
                        animal -> IntStream.of(animal.weight())
                    ).reduce(Integer::sum).getAsInt()
                )
            );

        for (var type : Animal.Type.values()) {
            if (!result.containsKey(type)) {
                result.put(type, 0);
            }
        }

        return result;
    }
}
