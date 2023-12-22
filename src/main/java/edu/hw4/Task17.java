package edu.hw4;

import java.util.Collection;
import java.util.List;

public final class Task17 {

    private Task17() {

    }

    public static boolean isSpidersBiteMoreThenDogs(Collection<Animal> animals) {
        List<Animal> listDogs = animals.stream().filter(a -> a.type().equals(Animal.Type.DOG)).toList();
        List<Animal> listBitingDogs = listDogs.stream().filter(Animal::bites).toList();
        List<Animal> listSpiders = animals.stream().filter(a -> a.type().equals(Animal.Type.SPIDER)).toList();
        List<Animal> listBitingSpiders = listSpiders.stream().filter(Animal::bites).toList();

        if (listDogs.isEmpty() || listBitingDogs.isEmpty()
            || listSpiders.isEmpty() || listBitingSpiders.isEmpty()) {
            return false;
        }
        return ((long) listBitingDogs.size() / listDogs.size())
            > ((long) listBitingSpiders.size() / listSpiders.size());
    }
}
