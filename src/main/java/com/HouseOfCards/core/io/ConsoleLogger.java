package com.HouseOfCards.core.io;

import java.util.Scanner;

public class ConsoleLogger implements ILogger {

    Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    @Override
    public void response(String message) {
        System.out.println(message);
    }
}
