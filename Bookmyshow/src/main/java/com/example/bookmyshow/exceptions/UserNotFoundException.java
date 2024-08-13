package com.example.bookmyshow.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        System.out.println(message);
    }
}
