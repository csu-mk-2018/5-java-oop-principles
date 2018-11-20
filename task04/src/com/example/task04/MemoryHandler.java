package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler {

    private ArrayList<String> messages = new ArrayList<String>();
    private int limit;
    private MessageHandler handler;

    /**
     * Конструтор класса MemoryHandler
     * @param handler текущий обработчик сообщений
     * @param limit  лимит сообщений для вывода
     */
    public MemoryHandler(MessageHandler handler, int limit) {
        this.handler = handler;
        this.limit = limit;
    }

    public void sendMessage(String message) throws Exception {
        this.messages.add(message);

        if (messages.size() == limit){
            this.writeMessages();
        }
    }

    /**
     * Вспомогательный метод для вывода сообщений в Handler'ы при достижении лимита
     */
    private void writeMessages() throws  Exception{
        for (String el : messages) {
            this.handler.sendMessage(el);
        }
        messages.clear();
    }
}