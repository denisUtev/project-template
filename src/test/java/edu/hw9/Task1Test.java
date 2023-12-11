package edu.hw9;

import edu.hw9.Task1.StatsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {

    @Test
    @DisplayName("тест системы сбора статистики")
    void testStatsCollector() {
        StatsCollector collector = new StatsCollector();

        collector.push("simple array", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        DoubleSupplier randomDoubleSupplier = () -> Math.random() * 100_000;
        for (int i = 1; i <= 50; i++) {
            double[] largeArray = DoubleStream.generate(randomDoubleSupplier).limit(3_000_000).toArray();
            collector.push("large array " + i, largeArray);
        }

        for (var metric : collector.stats()) {
            //System.out.println(metric);
            assertThat(metric.averageValue()).isEqualTo(getAverage(metric.data()));
            assertThat(metric.sumValue()).isEqualTo(getSum(metric.data()));
            assertThat(metric.minValue()).isEqualTo(getMin(metric.data()));
            assertThat(metric.maxValue()).isEqualTo(getMax(metric.data()));
        }
    }

    public double getAverage(double[] values) {
        Function<double[], Double>  averageFunc = (data) -> {
            double sum = Arrays.stream(data).sum();
            return sum / data.length;
        };
        return averageFunc.apply(values);
    }

    public double getSum(double[] values) {
        Function<double[], Double> sumFunc = (data) -> Arrays.stream(data).sum();
        return sumFunc.apply(values);
    }

    public double getMin(double[] values) {
        Function<double[], Double> minFunc = (data) -> Arrays.stream(data).min().orElse(-1);
        return minFunc.apply(values);
    }

    public double getMax(double[] values) {
        Function<double[], Double> maxFunc = (data) -> Arrays.stream(data).max().orElse(-1);
        return maxFunc.apply(values);
    }
}
