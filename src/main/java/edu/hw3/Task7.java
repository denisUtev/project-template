package edu.hw3;

import java.util.Comparator;

public final class Task7 {

    private Task7() {
    }

    public static class TreeMapComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            }
            return ((Comparable) o1).compareTo(o2);
        }
    }

}
