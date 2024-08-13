package com.example.bookmyshow.exceptions;

public class ShowNotFoundException extends Exception{
    public ShowNotFoundException(String message) {
        System.out.println(message);
    }
}
