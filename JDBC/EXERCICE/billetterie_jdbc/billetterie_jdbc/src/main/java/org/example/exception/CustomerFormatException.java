package org.example.exception;

public class CustomerFormatException extends Exception {
    public CustomerFormatException(String information) {
        super(information);
    }
}
