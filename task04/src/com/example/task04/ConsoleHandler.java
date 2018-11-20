package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    public void sendMessage(String message) throws Exception {
        System.out.println(message);
    }
}