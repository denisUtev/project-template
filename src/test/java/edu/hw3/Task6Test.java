package edu.hw3;

import edu.hw3.Task6.MyStockMarket;
import edu.hw3.Task6.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.clusterize;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {

    @Test
    @DisplayName("тест шестого задания hw3")
    void task1Test() {
        MyStockMarket stockMarket = new MyStockMarket();
        stockMarket.add(new Stock() {
            @Override
            public Record Stock(String name, int price) {
                return null;
            }
        });
        assertThat(clusterize("()()()")).isEqualTo(new String[]{"()", "()", "()"});
    }
}
