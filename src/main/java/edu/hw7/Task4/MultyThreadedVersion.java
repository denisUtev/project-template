package edu.hw7.Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class MultyThreadedVersion {

    private static final double CENTER_POS = 0.5d;
    private static final double RADIUS = 0.5d;

    private MultyThreadedVersion() {

    }

    @SuppressWarnings("MagicNumber")
    public static double getPI(long iterators, int countThreads) {
        long countIteratorsForEachThread = iterators / countThreads;
        List<ThreadPICalculator> threads = new ArrayList<>();
        for (int i = 0; i < countThreads; i++) {
            threads.add(new ThreadPICalculator(countIteratorsForEachThread));
        }
        threads.forEach(Thread::start);

        long sumCircleCount = 0;
        for (var thread : threads) {
            try {
                thread.join();
                sumCircleCount += thread.getCircleCount();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        return 4 * ((double) sumCircleCount / iterators);
    }

    private static class ThreadPICalculator extends Thread {

        private final long iterators;
        private long circleCount = 0;

        ThreadPICalculator(long iterators) {
            this.iterators = iterators;
        }

        @Override
        public void run() {
            for (int i = 0; i < iterators; i++) {
                double x = ThreadLocalRandom.current().nextDouble();
                double y = ThreadLocalRandom.current().nextDouble();
                if (Math.pow(x - CENTER_POS, 2) + Math.pow(y - CENTER_POS, 2) <= Math.pow(RADIUS, 2)) {
                    circleCount++;
                }
            }
        }

        public long getCircleCount() {
            return circleCount;
        }
    }
}
