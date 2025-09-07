package main.java;
import main.java.exceptions.*;
//import main.java.exceptions.InsufficientFundsException;
//import main.java.exceptions.NoSuchProductException;
//import main.java.exceptions.CartLimitExceededException;

import java.util.ArrayList;

public class ShoppingCart {
    private final ArrayList<String> cart = new ArrayList<>();
    private int cartLimit = 10;
    private double lastSubtotal;
    private double lastTax;
    private double lastDiscount;
    private double lastTotal;

    public void addToCart(String product)  {
        if (cart.size() >= cartLimit) {
            throw new CartLimitExceededException("Ліміт кошика досягнуто! Максимум " + cartLimit + " товарів.");
        }
        cart.add(product);
    }

    public void checkout(PriceCatalog catalog, double payment) {
        double subtotal = 0.0;
        for (String product : cart) {
            double price = catalog.getPrice(product);
            subtotal += price;
            lastSubtotal = subtotal;

        }

        double tax = subtotal * 0.1;
        lastTax = tax;
        double discount = Math.random() * 0.1 + 0.05;

        if (cart.contains("Milk")) {
            discount += 0.05;
        }
        lastDiscount = discount;
        double total = subtotal + tax;
        total = total * (1 - discount);
        lastTotal = total;

        if (payment < total) {
            throw new InsufficientFundsException("Упс, оплати недостатньо, треба " + String.format("%.2f", total));
        }
        printReceipt(catalog);
        System.out.println("Оплата успішна! Загальна сума: " + String.format("%.2f", total));

    }

    public ArrayList<String> getCart() {
        return new ArrayList<>(cart);
    }

    public void printReceipt(PriceCatalog catalog) {
        System.out.println("------ Чек ------");
        for (String product : cart) {
            try {
                double price = catalog.getPrice(product);
                System.out.println(product + ": " + String.format("%.2f", price) + " грн");
            } catch (NoSuchProductException e) {
                System.out.println(product + ": Ціна не знайдена!");
            }
        }


        System.out.println("-----------------");
        System.out.println("Підсумок: " + String.format("%.2f", lastSubtotal) + " грн");
        System.out.println("Податок (10%): " + String.format("%.2f", lastTax) + " грн");
        System.out.println("Знижка: " + String.format("%.2f", lastDiscount * 100) + "%");
        System.out.println("До сплати: " + String.format("%.2f", lastTotal) + " грн");
        System.out.println("-----------------");
    }
}