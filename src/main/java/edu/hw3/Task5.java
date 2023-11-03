package edu.hw3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static java.util.Collections.reverseOrder;

public final class Task5 {

    private Task5() {

    }

    public static Object[] parseContacts(String[] persons, String type) {
        if (persons == null) {
            return new String[] {};
        }
        List<String> listPresons = Arrays.asList(persons);
        HashMap<String, String> surnamePersonsMap = getSurnamePersonsMap(persons);

        if (type.equals("ASC")) {
            listPresons = surnamePersonsMap.keySet().stream().sorted().toList();
        }
        if (type.equals("DESC")) {
            listPresons = surnamePersonsMap.keySet().stream().sorted(reverseOrder()).toList();
        }

        return listPresons.stream().map(surnamePersonsMap::get).toArray();
    }

    private static HashMap<String, String> getSurnamePersonsMap(String[] persons) {
        HashMap<String, String> surnamePersonsMap = new HashMap<>();
        for (String person : persons) {
            String[] initials = person.split(" ");
            surnamePersonsMap.put(initials[initials.length - 1], person);
        }
        return surnamePersonsMap;
    }
}
