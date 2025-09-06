package main.java;

import java.util.ArrayList;
import java.util.Collections;


public class ProductInventory {
    private final ArrayList<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
    }

    public void removeProduct(String name) {
        if (!products.contains(name)) {
            throw new main.java.exceptions.OutOfStockException("Товар " + name + " закінчився!");
        }
        products.remove(name);
    }

    public void sortProducts() {
        Collections.sort(products);

    }

    public ArrayList<String> getProducts() {
        return new ArrayList<>(products);

    }
}
