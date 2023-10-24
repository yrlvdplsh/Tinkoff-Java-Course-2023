package edu.hw3.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

    public class MyStockMarket implements StockMarket {
        private PriorityQueue<Stock> stonks = new PriorityQueue<>();

    @Override
    public void add(Stock stock) {
        if (stock.ticker().equals("VTBR") || stock.name().contains("ВТБ")) {
            throw new IllegalArgumentException("better do charity");
        }
        stonks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stonks.remove(stock);
    }

    @Override
    public Stock getMostValuableStock() {
        return stonks.peek();
    }

    public ArrayList<Stock> getStonks() {
        ArrayList<Stock> result = new ArrayList<>(stonks.stream().toList());
        Collections.sort(result);
        return result;
    }
}
