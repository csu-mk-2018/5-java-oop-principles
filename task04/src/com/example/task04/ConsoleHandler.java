package com.example.task04;

public class ConsoleHandler implements MessageHandler {

    @Override
    public void PrintMessage(String message) {

        System.out.println(message);
    }
}
