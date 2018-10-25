package com.example.task04;

import java.util.*;

public class MemoryHandler implements MessageHandler {

    private ArrayList<String> messages = new ArrayList<>();
    MessageHandler handler;
    private long limit;

    public MemoryHandler(MessageHandler handler, long limit) {
        if (limit > 0 && handler != null) {
            this.handler = handler;
            this.limit = limit;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private String concatMessages() {
        String resMessage = "";
        for (String msg : messages) {
            resMessage += msg;
        }
        return resMessage;
    }

    @Override
    public void printMessage(String message) {
        messages.add(message);
        if (messages.size() == limit) {
            handler.printMessage(this.concatMessages());
            messages.clear();
        }
    }

}