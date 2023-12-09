package edu.hw7.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private final List<Thread> threadList = new ArrayList<>();
    private final AtomicInteger counter;

    public AtomicCounter(int countThreads, int countIncrements) {
        counter = new AtomicInteger(0);
        for (int i = 0; i < countThreads; i++) {
            threadList.add(new IncrementThread(countIncrements));
            threadList.get(i).start();
        }
    }

    public void waitThreads() {
        for (Thread thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getCounter() {
        return counter.get();
    }

    private class IncrementThread extends Thread {

        private final int countIncrements;

        IncrementThread(int countIncrements) {
            this.countIncrements = countIncrements;
        }

        @Override
        public void run() {
            for (int i = 0; i < countIncrements; i++) {
                counter.getAndIncrement();
            }
        }
    }

}
