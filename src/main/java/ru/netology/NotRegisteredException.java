package ru.netology;

public class NotRegisteredException extends RuntimeException {
    NotRegisteredException(String message) {
        super(message);
    }
}