package edu.hw4;

import java.util.Collection;

public final class Task9 {

    private Task9() {

    }

    public static Integer getCountOfPawsAnimals(Collection<Animal> animals) {
        return animals.stream().map(Animal::paws).reduce(0, Integer::sum);
    }
}
