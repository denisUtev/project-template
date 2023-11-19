package edu.hw3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import static java.util.Collections.reverseOrder;

public final class Task5 {

    private Task5() {

    }

    public static Object[] parseContacts(String[] persons, TypeSorting type) {
        if (persons == null) {
            return new String[] {};
        }
        List<Initials> listPresons = new ArrayList<>();
        HashMap<Initials, String> surnamePersonsMap = getSurnamePersonsMap(persons);

        if (type.equals(TypeSorting.ASC)) {
            listPresons = surnamePersonsMap.keySet().stream()
                .sorted(Comparator.comparing(a -> a.surname)).toList();
        }
        if (type.equals(TypeSorting.DESC)) {
            listPresons = surnamePersonsMap.keySet().stream()
                .sorted(reverseOrder(Comparator.comparing(a -> a.surname))).toList();
        }

        return listPresons.stream().map(surnamePersonsMap::get).toArray();
    }

    private static HashMap<Initials, String> getSurnamePersonsMap(String[] persons) {
        HashMap<Initials, String> surnamePersonsMap = new HashMap<>();
        for (String person : persons) {
            String[] initials = person.split(" ");
            surnamePersonsMap.put(new Initials(initials[initials.length - 1], initials[0]), person);
        }
        return surnamePersonsMap;
    }


    record Initials(String surname, String name){}

    public enum TypeSorting {
        ASC,
        DESC
    }
}
