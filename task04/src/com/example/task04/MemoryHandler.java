package com.example.task04;

import java.io.IOException;
import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private ArrayList<String> messages = new ArrayList<String>();
    private int limit;
    private MessageHandler handler;

    private void unload() throws IOException {

        for (String message : messages) {
            handler.PrintMessage(message);
        }
        messages.clear();
    }

    public MemoryHandler(MessageHandler handler, int limit) {

        this.handler = handler;
        this.limit = limit;
    }

    @Override
    public void PrintMessage(String message) throws IOException {

        if (messages.size() < limit) {
            messages.add(message);
        } else {
            this.unload();
        }
    }
}
