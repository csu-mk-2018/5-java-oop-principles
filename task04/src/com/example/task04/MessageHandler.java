package com.example.task04;

/**
 * Интерфейс для Handler-ов вывода сообщений логгера
 */
public interface MessageHandler {

    ConsoleHandler getConsoleHandler();

    FileHandler getFileHandler();

    RotationFileHandler getRotationFileHandler();

    MemoryHandler getMemoryHandler();
}
