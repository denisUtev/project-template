package edu.hw9.Task1;

import java.util.function.Function;

public class MetricCalculator extends Thread {

    private final double[] values;
    private final Function<double[], Double> metricFunc;

    private double result = 0;

    public MetricCalculator(double[] values, Function<double[], Double> metricFunc) {
        this.values = values;
        this.metricFunc = metricFunc;
    }

    @Override
    public void run() {
        result = metricFunc.apply(values);
    }

    public double getResult() {
        return result;
    }
}
