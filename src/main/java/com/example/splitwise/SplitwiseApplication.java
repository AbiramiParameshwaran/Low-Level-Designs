package com.example.splitwise;

import com.example.splitwise.command.CommandExecutor;
import com.example.splitwise.command.RegisterUser;
import com.example.splitwise.command.SettleUpGroup;
import com.example.splitwise.command.SettleUpUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication implements CommandLineRunner {
    private CommandExecutor commandExecutor;
    private RegisterUser registerUser;
    public SplitwiseApplication(CommandExecutor commandExecutor,
                                RegisterUser registerUser
                                ) {
        this.commandExecutor = commandExecutor;
        this.registerUser = registerUser;
    }
    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);
        commandExecutor.addCommand(registerUser);
        System.out.println(commandExecutor.getCommands());
        while (true) {
            String input = sc.next();
            commandExecutor.execute(input);
        }
    }
}
