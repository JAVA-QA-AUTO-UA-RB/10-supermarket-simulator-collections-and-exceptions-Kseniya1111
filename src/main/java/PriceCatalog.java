package main.java;

import main.java.exceptions.NoSuchProductException;

import java.util.HashMap;
import java.util.HashSet;

public class PriceCatalog {

    private HashMap<String, Double> prices = new HashMap<>();


    public void addPrice(String product, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Товар  не може коштувати менше 0");
        }
        prices.put(product, price);

    }

    public double getPrice(String product) throws NoSuchProductException {
        if (!prices.containsKey(product)) {
            throw new NoSuchProductException("Товару+" + product + " немає у каталозі");
        }
        return prices.get(product);
    }

    public HashMap<String, Double> getPrices() {
        return prices;
    }

}
