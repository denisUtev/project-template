package edu.hw8;

import edu.hw8.Task2.FixedThreadPool;
import edu.hw8.Task2.ThreadPool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.function.Function;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("тест FixedThreadPool")
    void testFixedThreadPool() {
        Function<Integer, Long> getNumberFib = (n) -> {
            long a = 1;
            long b = 1;
            long c = 0;
            if (n == 1) {
                return a;
            }
            if (n == 2) {
                return b;
            }
            for (int i = 2; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        };
        ThreadPool threadPool = FixedThreadPool.create(10);
        threadPool.start();

        long start;
        long end;
        long singleThreadTime;
        long multiThreadTime;
        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            getNumberFib.apply(10_000_000);
        }
        end = System.nanoTime();
        singleThreadTime = end - start;
        System.out.println("Однопоточная программа: " + singleThreadTime);

        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            Thread fib1 = new Thread(() -> {
                getNumberFib.apply(10_000_000);
            });
            threadPool.execute(fib1);
        }
        end = System.nanoTime();
        multiThreadTime = end - start;
        System.out.println("Многопоточная программа: " + multiThreadTime);
        assertThat(multiThreadTime < singleThreadTime).isEqualTo(true);
    }
}
