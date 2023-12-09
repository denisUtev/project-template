package edu.hw7;

import java.math.BigInteger;
import java.util.stream.LongStream;

public final class Task2 {

    private Task2() {

    }

    public static Long getFactorialByParallelStream(int degree) {
        return LongStream.range(1, degree + 1)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply)
            .longValue();
    }
}
