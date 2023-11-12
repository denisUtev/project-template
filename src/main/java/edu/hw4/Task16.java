package edu.hw4;

import java.util.Collection;
import java.util.List;

public final class Task16 {

    private Task16() {

    }

    public static List<Animal> getSortedAnimalsByTypeSexName(Collection<Animal> animals) {
        return animals.stream().sorted((a, b) -> {
            int differenceType = a.type().ordinal() - b.type().ordinal();
            if (differenceType != 0) {
                return differenceType;
            }
            int differenceSex = a.sex().ordinal() - b.sex().ordinal();
            if (differenceSex != 0) {
                return differenceSex;
            }
            return a.name().compareTo(b.name());
        }).toList();
    }
}
