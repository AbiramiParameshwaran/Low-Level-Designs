package com.example.splitwise.command;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegisterUser implements Command{
    @Override
    public boolean matches(String input) {
        List<String> words= List.of(input.split(" "));
        if(words.get(0).equals("Register")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute() {
        System.out.println("Executed");
    }
}
