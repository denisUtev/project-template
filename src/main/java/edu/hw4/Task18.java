package edu.hw4;

import java.util.Collection;
import java.util.Comparator;

public final class Task18 {

    private Task18() {

    }

    public static Animal getHeviestFIsh(Collection<Animal>... animals) {
        Animal theHeviestFish = null;
        for (var listAnimals : animals) {
            var heviestFish = listAnimals.stream().filter(a -> a.type().equals(Animal.Type.FISH))
                .max(Comparator.comparingInt(Animal::weight));
            if (heviestFish.isPresent()
                && (theHeviestFish == null || heviestFish.get().weight() > theHeviestFish.weight())) {
                theHeviestFish = heviestFish.get();
            }
        }
        return theHeviestFish;
    }
}
