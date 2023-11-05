package edu.hw4;

import java.util.Collection;

public final class Task12 {

    private Task12() {

    }

    public static Integer getCountAnimalsWhereWeightMoreHeight(Collection<Animal> animals) {
        return (int)animals.stream().filter(animal -> animal.weight() > animal.height()).count();
    }
}
