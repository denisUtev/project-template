package edu.hw9.Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public final class StatsCollector {

    private final List<Metric> metrics = new ArrayList<>();
    private final Function<double[], Double> averageFunc;
    private final Function<double[], Double> sumFunc;
    private final Function<double[], Double> minFunc;
    private final Function<double[], Double> maxFunc;
    private final ThreadPoolExecutor pushExecutor;
    private static final int COUNT_THREADS = 10;
    private static final int WAIT_TIME = 60;

    public StatsCollector() {
        averageFunc = (data) -> {
            double sum = Arrays.stream(data).sum();
            return sum / data.length;
        };
        sumFunc = (data) -> Arrays.stream(data).sum();
        minFunc = (data) -> Arrays.stream(data).min().orElse(-1);
        maxFunc = (data) -> Arrays.stream(data).max().orElse(-1);
        pushExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(COUNT_THREADS);
    }

    public void push(String name, double[] values) {
        pushExecutor.submit(new Thread(() -> {
            Metric newMetric = getNewMetric(name, values);
            synchronized (metrics) {
                metrics.add(newMetric);
            }
        }));
    }

    @SuppressWarnings("MagicNumber")
    private Metric getNewMetric(String name, double[] values) {
        MetricCalculator[] metricCalculators = new MetricCalculator[4];
        metricCalculators[0] = new MetricCalculator(values, averageFunc);
        metricCalculators[1] = new MetricCalculator(values, sumFunc);
        metricCalculators[2] = new MetricCalculator(values, minFunc);
        metricCalculators[3] = new MetricCalculator(values, maxFunc);
        for (MetricCalculator metricCalculator : metricCalculators) {
            metricCalculator.start();
        }
        for (MetricCalculator metricCalculator : metricCalculators) {
            try {
                metricCalculator.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return new Metric(name, metricCalculators[0].getResult(), metricCalculators[1].getResult(),
            metricCalculators[2].getResult(), metricCalculators[3].getResult(), values);
    }

    public List<Metric> stats() {
        awaitTerminationAfterShutdown(pushExecutor);
        return metrics;
    }

    private void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(WAIT_TIME, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public record Metric(String name, double averageValue, double sumValue,
                         double minValue, double maxValue, double[] data){}
}
