package edu.hw3.Task6;

import java.util.Collections;
import java.util.PriorityQueue;

public class MyStockMarket implements StockMarket {

    PriorityQueue<Stock> stockQueue = new PriorityQueue<>(Collections.reverseOrder());

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.element();
    }
}

