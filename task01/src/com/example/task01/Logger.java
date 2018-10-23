package com.example.task01;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Logger {

    private final String name;
    private Level level;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR,
    }

    Logger(String name) {
        this.name = name;
        loggers.put(this.name, this);
    }

    private Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(this.name, this);
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

    public void debug(String message) {
        logMessage(Level.DEBUG, message);
    }

    public void debug(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.DEBUG, message);
    }

    public void info(String message) {
        logMessage(Level.INFO, message);
    }

    public void info(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.INFO, message);
    }

    public void warning(String message) {
        logMessage(Level.WARNING, message);
    }

    public void warning(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.WARNING, message);
    }

    public void error(String message) {
        logMessage(Level.ERROR, message);
    }

    public void error(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.ERROR, message);
    }

    public void logMessage(Level level, String message) {
        //[WARNING] 2018.07.17 09:56:32 myLogger - something weird happened
        if (level != null && level.ordinal() >= this.level.ordinal()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            Date date = new Date();
            String log = String.format("[%s] %s %s - %s", level.toString(), dateFormat.format(date), name, message);
            System.out.println(log);
        }
    }

}