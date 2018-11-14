package com.example.task04;

/**
 * Интерфейс для Handler-ов вывода сообщений логгера
 */
public interface MessageHandler {

    /**
     * Выводит сообщения в файл или на консоль
     * @param message выводимая строка
     */
    public void sendMessage(String message) throws Exception;
}
