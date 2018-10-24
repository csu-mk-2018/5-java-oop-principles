package com.example.task04;

import java.util.*;
import java.text.*;

public class Logger {
    private String name;
    private ImportanceLevel impLevel = ImportanceLevel.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();

    private ArrayList<MessageHandler> handlers = new ArrayList<>();

    private Logger(String name, MessageHandler firstHandler) {
        this.name = name;
        this.handlers.add(firstHandler);
    }

    private Logger(String name) {
        this.name = name;
    }

    private static Logger createNewLogger(String name, MessageHandler handler) {
        Logger newLogger = new Logger(name, handler);
        loggers.put(name, newLogger);
        return newLogger;
    }

    private static Logger createNewLogger(String name) {
        Logger newLogger = new Logger(name);
        loggers.put(name, newLogger);
        return newLogger;
    }

    /**
     * Возвращает из списка логгеров либо создает и возвращает логгер (в
     * зависимости от его наличия в списке).
     *
     * @param name имя логгера
     * @return экземпляр логгера
     */
    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? createNewLogger(name) : logger;
    }

    /**
     * Возвращает из списка логгеров либо создает и возвращает логгер (в
     * зависимости от его наличия в списке).
     *
     * @param name    имя логгера
     * @param handler первый обработчик, добавляемый в новый логгер (если он будет создан, иначе добавляет обработчик в старый)
     * @return логгер с заданным первым обработчиком и именем
     */
    public static Logger getLogger(String name, MessageHandler handler) {
        Logger logger = loggers.get(name);
        if (logger != null) {
            logger.addHandler(handler);
        } else {
            logger = createNewLogger(name, handler);
        }
        return logger;
    }

    /**
     * Добавление обработчика (reference на него) в список обработчиков данного логгера (убрать их нельзя).
     *
     * @param handler добавляемый обработчик
     */
    public void addHandler(MessageHandler handler) {
        handlers.add(handler);
    }

    /**
     * Получение имени логгера.
     *
     * @return строка, представляющая имя логгера
     */
    public String getName() {
        return name;
    }

    /**
     * Задание имени логгера.
     *
     * @param name новое имя логгера
     */
    public void setName(String name) {
        loggers.remove(name);
        this.name = name;
        loggers.put(name, this);
    }

    private static String getNowDateFormat() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        return formatForDateNow.format(dateNow);
    }

    private void printMessage(String message, ImportanceLevel impLevel) {
        String printableMessage = "[" + impLevel.name() + "] " + getNowDateFormat() + String.format(" %s - %s", name, message);
        for (MessageHandler handler : handlers) {
            handler.printMessage(printableMessage);
        }
    }

    /**
     * Отправить сообщение уровня DEBUG в обработчик.
     *
     * @param message текст сообщения
     */
    public void debug(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.DEBUG.ordinal()) {
            printMessage(message, ImportanceLevel.DEBUG);
        }
    }

    /**
     * Отправить сообщение уровня DEBUG в обработчик.
     *
     * @param format формат сообщения
     * @param params параметры для формата
     */
    public void debug(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.DEBUG.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.DEBUG);
        }
    }

    /**
     * Отправить сообщение уровня INFO в обработчик.
     *
     * @param message текст сообщения
     */
    public void info(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.INFO.ordinal()) {
            printMessage(message, ImportanceLevel.INFO);
        }
    }

    /**
     * Отправить сообщение уровня INFO в обработчик.
     *
     * @param format формат сообщения
     * @param params параметры для формата
     */
    public void info(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.INFO.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.INFO);
        }
    }

    /**
     * Отправить сообщение уровня WARNING в обработчик.
     *
     * @param message текст сообщения
     */
    public void warning(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.WARNING.ordinal()) {
            printMessage(message, ImportanceLevel.WARNING);
        }
    }

    /**
     * Отправить сообщение уровня WARNING в обработчик.
     *
     * @param format формат сообщения
     * @param params параметры для формата
     */
    public void warning(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.WARNING.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.WARNING);
        }
    }

    /**
     * Отправить сообщение уровня ERROR в обработчик.
     *
     * @param message текст сообщения
     */
    public void error(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.ERROR.ordinal()) {
            printMessage(message, ImportanceLevel.ERROR);
        }
    }

    /**
     * Отправить сообщение уровня ERROR в обработчик.
     *
     * @param format формат сообщения
     * @param params параметры для формата
     */
    public void error(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.ERROR.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.ERROR);
        }
    }

    /**
     * Отправить сообщение заданного уровня в обработчик.
     *
     * @param message  текст сообщения
     * @param impLevel уровень важности сообщения
     */
    public void log(String message, ImportanceLevel impLevel) {
        if (this.impLevel.ordinal() <= impLevel.ordinal()) {
            printMessage(message, impLevel);
        }
    }

    /**
     * Отправить сообщение заданного уровня в обработчик.
     *
     * @param format   формат сообщения
     * @param impLevel уровень важности сообщения
     * @param params   параметры для формата
     */
    public void log(String format, ImportanceLevel impLevel, Object... params) {
        if (this.impLevel.ordinal() <= impLevel.ordinal()) {
            printMessage(String.format(format, params), impLevel);
        }
    }

    public ImportanceLevel getLevel() {
        return impLevel;
    }

    public void setLevel(ImportanceLevel impLevel) {
        this.impLevel = impLevel;
    }
}
