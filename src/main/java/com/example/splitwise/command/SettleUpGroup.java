package com.example.splitwise.command;

import org.springframework.stereotype.Component;

@Component
public class SettleUpGroup implements Command{
    @Override
    public boolean matches(String input) {
        return false;
    }

    @Override
    public void execute() {

    }
}
