package edu.hw4;

import java.util.Collection;

public final class Task14 {

    private Task14() {

    }

    public static Boolean isHaveDogHighK(Collection<Animal> animals, int k) {
        return animals.stream().anyMatch(animal ->
            animal.type().equals(Animal.Type.DOG) && animal.height() > k);
    }
}
