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
        stockMarket.add(new Stock("stock1", 10));
        stockMarket.add(new Stock("stock2", 100));
        stockMarket.add(new Stock("stock3", 99));

        assertThat(stockMarket.mostValuableStock().name()).isEqualTo("stock2");
        assertThat(stockMarket.mostValuableStock().name()).isEqualTo("stock2");

        stockMarket.add(new Stock("stock4", 120));
        Stock stock5 = new Stock("stock5", 125);
        stockMarket.add(stock5);
        assertThat(stockMarket.mostValuableStock().name()).isEqualTo("stock5");
        stockMarket.remove(stock5);
        assertThat(stockMarket.mostValuableStock().name()).isEqualTo("stock4");
    }
}
