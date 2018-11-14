package com.example.task04;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Logger {

    private final String name;
    private Level level;
    private ArrayList<MessageHandler> handlers = new ArrayList<>();
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Logger(String name, MessageHandler handler) {
        this.name = name;
        loggers.put(this.name, this);
        this.handlers.add(handler);
    }

    private Logger(String name) {
        this.name = name;
        loggers.put(this.name, this);
    }

    public void setHandler(MessageHandler handler) {
        this.handlers.add(handler);
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public Level getLevel() {
        return this.level;
    }

    public static Logger getLogger(String name) {

        Logger temp = loggers.get(name);
        if (temp != null)
            return temp;

        temp = loggers.put(name, new Logger(name));
        return temp;
    }

    public void debug(String message) throws Exception {
        logMessage(Level.DEBUG, message);
    }

    public void debug(String strFormat, Object... args) throws Exception {
        String message = String.format(strFormat, args);
        logMessage(Level.DEBUG, message);
    }

    public void info(String message) throws Exception {
        logMessage(Level.INFO, message);
    }

    public void info(String strFormat, Object... args) throws Exception {
        String message = String.format(strFormat, args);
        logMessage(Level.INFO, message);
    }

    public void warning(String message) throws Exception {
        logMessage(Level.WARNING, message);
    }

    public void warning(String strFormat, Object... args) throws Exception {
        String message = String.format(strFormat, args);
        logMessage(Level.WARNING, message);
    }

    public void error(String message) throws Exception {
        logMessage(Level.ERROR, message);
    }

    public void error(String strFormat, Object... args) throws Exception {
        String message = String.format(strFormat, args);
        logMessage(Level.ERROR, message);
    }

    private void logMessage(Level level, String message) throws Exception{
        //[WARNING] 2018.07.17 09:56:32 myLogger - something weird happened
        if (level != null && level.ordinal() >= this.level.ordinal()) {
            Date date = new Date();
            String log = String.format("[%s] %s %s - %s", level.toString(), DATE_FORMAT.format(date), name, message);
            for (MessageHandler handler : handlers) {
                handler.sendMessage(log);
            }
        }
    }

}