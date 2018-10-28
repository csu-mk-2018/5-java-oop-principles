package com.example.task04;

/**
 * Интерфейс для Handler-ов вывода сообщений логгера
 */
public interface MessageHandler {

    /*
    Метод выводит сообщения в файл или консоль, в зависимости от hadler'а
    На вход принимает строку String
     */
    public void sendMessage(String message);
}
