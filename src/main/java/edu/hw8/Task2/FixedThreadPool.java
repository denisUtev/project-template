package edu.hw8.Task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class FixedThreadPool implements ThreadPool {

    private final Thread[] threads;
    private final BlockingQueue<Runnable> queue;


    private final AtomicBoolean isClosed = new AtomicBoolean(false);

    private FixedThreadPool(int countThreads) {
        threads = new Thread[countThreads];
        queue = new LinkedBlockingQueue<>();
    }

    public static FixedThreadPool create(int countThreads) {
        return new FixedThreadPool(countThreads);
    }

    @Override
    public void start() {
        new Thread(() -> {
            while (!isClosed.get()) {
                synchronized (queue) {
                    for (int i = 0; i < threads.length; i++) {
                        if (threads[i] == null || !threads[i].isAlive() && !queue.isEmpty()) {
                            try {
                                threads[i] = (Thread) queue.take();
                                threads[i].start();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }).start();
    }

    @Override
    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    @Override
    public void close() {
        isClosed.set(true);
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
