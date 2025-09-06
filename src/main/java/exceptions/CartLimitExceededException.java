package main.java.exceptions;

public class CartLimitExceededException extends Exception {
    public CartLimitExceededException(String message) {
        super(message);
    }
}
