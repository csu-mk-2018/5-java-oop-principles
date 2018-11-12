package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {
    final private String name;
    private Level level;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
    private static Map<String, Logger> loggers = new HashMap<>();

    public enum Level {DEBUG, INFO, WARNING, ERROR}

    private Logger(String name) {
        this.name = name;
        this.level = Level.DEBUG;
        loggers.put(this.name, this);
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? new Logger(name) : logger;
    }

    public void log(Level level, String message) {
        if (checkLevel(level)) {
            printLog(level, message);
        }
    }

    public void log(Level level, String format, Object... varargs) {
        if (checkLevel(level)) {
            printLog(level, String.format(format, varargs));
        }
    }

    public void debug(String message) {
        if (checkLevel(Level.DEBUG)) {
            printLog(Level.DEBUG, message);
        }
    }

    public void debug(String format, Object... varargs) {
        if (checkLevel(Level.DEBUG)) {
            printLog(Level.DEBUG, String.format(format, varargs));
        }
    }

    public void info(String message) {
        if (checkLevel(Level.INFO)) {
            printLog(Level.INFO, message);
        }
    }

    public void info(String format, Object... varargs) {
        if (checkLevel(Level.INFO)) {
            printLog(Level.INFO, String.format(format, varargs));
        }
    }

    public void warning(String message) {
        if (checkLevel(Level.WARNING)) {
            printLog(Level.WARNING, message);
        }
    }

    public void warning(String format, Object... varargs) {
        if (checkLevel(Level.WARNING)) {
            printLog(Level.WARNING, String.format(format, varargs));
        }
    }

    public void error(String message) {
        printLog(Level.ERROR, message);
    }

    public void error(String format, Object... varargs) {
        printLog(Level.ERROR, String.format(format, varargs));
    }

    private void printLog(Level level, String message) {
        String dateStr = DATE_FORMAT.format(new Date());
        System.out.println(String.format("[%s] %s %s - %s", level, dateStr, name, message));
    }

    private boolean checkLevel(Level level) {
        return level.ordinal() >= this.level.ordinal();
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }
}