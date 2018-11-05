package com.example.task04;

import java.io.IOException;
import java.util.*;

/**
 * Обработчик для буферизации сообщений в памяти и передачи их другому обработчику
 */
public class MemoryHandler implements MessageHandler {

    private ArrayList<String> messages = new ArrayList<>();
    private final MessageHandler handler;
    private final long limit;

    /**
     * Конструктор MemoryHandler
     *
     * @param handler обработчик в который будут переданы сообщения
     * @param limit   максимальное количество сообщений для буферизации
     */
    public MemoryHandler(MessageHandler handler, long limit) {
        if (limit > 0 && handler != null) {
            this.handler = handler;
            this.limit = limit;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Передаёт все хранимые сообщения обработчику
     */
    public void flush() throws IOException {
        for (String message : messages) {
            handler.printMessage(message);
        }
        messages.clear();
    }

    @Override
    public void printMessage(String message) throws IOException {
        messages.add(message);
        if (messages.size() == limit) {
            this.flush();
        }
    }

}