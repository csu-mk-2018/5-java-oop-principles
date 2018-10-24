package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private ArrayList<String> bufferedMessages = new ArrayList<>();

    private final MessageHandler handler;

    private final int bufCapacity;

    public MemoryHandler(int bufCapacity, MessageHandler handler) {
        if (bufCapacity < 0 || handler == null) {
            throw new IllegalArgumentException();
        } else {
            this.bufCapacity = bufCapacity;
            this.handler = handler;
        }
    }

    @Override
    public void printMessage(String message) {
        if (bufCapacity - 1 == bufferedMessages.size()) {
            for (String msg : bufferedMessages) {
                handler.printMessage(msg);
            }
            handler.printMessage(message);
            bufferedMessages.clear();
        } else {
            bufferedMessages.add(message);
        }
    }
}
