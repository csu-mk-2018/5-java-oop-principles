package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {

    private String name;
    private ImportanceLevel impLevel = ImportanceLevel.DEBUG;

    private static HashMap<String, Logger> loggers = new HashMap<>();

    private Logger(String name) {
        this.name = name;
    }

    private static Logger createNewLogger(String name) {
        Logger newLogger = new Logger(name);
        loggers.put(name, newLogger);
        return newLogger;
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        return logger == null ? createNewLogger(name) : logger;
    }

    public String getName() {
        return name;
    }

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
        System.out.println(printableMessage);
    }

    public void debug(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.DEBUG.ordinal()) {
            printMessage(message, ImportanceLevel.DEBUG);
        }
    }

    public void debug(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.DEBUG.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.DEBUG);
        }
    }

    public void info(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.INFO.ordinal()) {
            printMessage(message, ImportanceLevel.INFO);
        }
    }

    public void info(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.INFO.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.INFO);
        }
    }

    public void warning(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.WARNING.ordinal()) {
            printMessage(message, ImportanceLevel.WARNING);
        }
    }

    public void warning(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.WARNING.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.WARNING);
        }
    }

    public void error(String message) {
        if (impLevel.ordinal() <= ImportanceLevel.ERROR.ordinal()) {
            printMessage(message, ImportanceLevel.ERROR);
        }
    }

    public void error(String format, Object... params) {
        if (impLevel.ordinal() <= ImportanceLevel.ERROR.ordinal()) {
            printMessage(String.format(format, params), ImportanceLevel.ERROR);
        }
    }

    public void log(String message, ImportanceLevel impLevel) {
        if (this.impLevel.ordinal() <= impLevel.ordinal()) {
            printMessage(message, impLevel);
        }
    }

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
