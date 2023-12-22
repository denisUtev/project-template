package edu.hw4.Task19;

import edu.hw4.Animal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class Task19 {

    private Task19() {

    }

    public static Map<String, Set<ValidationError>> getMapValidationErrors(Collection<Animal> animals) {
        return animals.stream().map(a -> {
            Set<ValidationError> setErrors = new HashSet<>();
            if (a.age() < 0) {
                setErrors.add(new ValidationError("The age cannot be less than zero"));
            }
            if (a.weight() < 0) {
                setErrors.add(new ValidationError("The weight cannot be less than zero"));
            }
            if (a.height() < 0) {
                setErrors.add(new ValidationError("The height cannot be less than zero"));
            }

            return Map.entry(a.name(), setErrors);
        }).filter(a -> !a.getValue().isEmpty()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
