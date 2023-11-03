package edu.hw3;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public final class Task8 {

    private Task8() {

    }

    public static class BackwardIterator<T> implements Iterator {

        Stack<T> stack = new Stack<>();
        int index;

        public BackwardIterator(Collection<T> list) {
            stack.addAll(list);
            index = list.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            return stack.pop();
        }
    }
}
