package edu.hw3;

import java.util.ArrayList;
import java.util.List;

public final class Task2 {

    private Task2() {

    }

    public static String[] clusterize(String stroke) {
        List<String> result = new ArrayList<>();
        StringBuilder cluster = new StringBuilder();
        int countOpenedBrackets = 0;
        for (int i = 0; i < stroke.length(); i++) {
            if (stroke.charAt(i) == '(') {
                if (i > 0 && countOpenedBrackets == 0) {
                    result.add(cluster.toString());
                    cluster = new StringBuilder();
                }
                countOpenedBrackets++;
            } else {
                countOpenedBrackets--;
            }
            cluster.append(stroke.charAt(i));
        }
        if (!cluster.isEmpty()) {
            result.add(cluster.toString());
        }

        return result.toArray(new String[0]);
    }
}
