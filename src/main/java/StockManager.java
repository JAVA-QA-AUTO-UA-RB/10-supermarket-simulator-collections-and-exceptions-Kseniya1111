package main.java;

import main.java.exceptions.OutOfStockException;

import java.util.HashMap;

public class StockManager {

    private HashMap<String, Integer> stock = new HashMap<>();

    public void addStock(String product, int quantity) throws IllegalArgumentException {
        if (quantity < 0)
            throw new IllegalArgumentException("Не може бути кількість товару " + product + "меньша за 0");

        stock.put(product, quantity);
    }


    public void reduceStock(String product) throws OutOfStockException {

        if (!stock.containsKey(product)) {
            throw new OutOfStockException("Товар відсутній");
        }

        int current = stock.get(product);
        if (current <= 0) {
            throw new OutOfStockException("Упс, товар" + product + " закінчився");
        }

        stock.put(product, current - 1);

    }

    public HashMap<String, Integer> getStock() {
        return new HashMap<>(stock);
    }
}