package com.HouseOfCards.core.io;

public interface ILogger {
    String ask(String prompt);
    void response(String message);
}
