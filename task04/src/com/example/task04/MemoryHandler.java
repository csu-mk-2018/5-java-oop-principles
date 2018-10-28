package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private ArrayList<String> messages = new ArrayList<String>();
    private int limit;

    MemoryHandler() {
        limit = 15;
    }

    MemoryHandler(int limit) {
        this.limit = limit;
    }

    /*
    Добавляем сообщение в лист, если размера лист > лимита, выводим
    все в хендлер
     */
    public void sendMessage(String message) {
        messages.add(message);

        if (messages.size() >= limit)
            writeMessages(messages);
    }

    /*
       Вспомогоательный метод, выводящий все сообщения из памяти в handler
       На вход принимает list с сообщениями
    */
    private void writeMessages(ArrayList<String> messages) {
        for (String el : messages) {
            System.out.println(el);
        }

        messages.clear();
    }
}
