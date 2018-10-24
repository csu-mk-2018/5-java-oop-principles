package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler {

    private ArrayList<String> messages = new ArrayList<String>();

    public void SendMessage(String message) {
        messages.add(message);

        System.out.println(messages.size());
        if (messages.size() >= 100)
            writeMessages(messages);
    }

    private void writeMessages(ArrayList<String> messages) {
        for (String el : messages) {
            System.out.println(el);
        }

        messages.clear();
    }
}
