package com.example.task01;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Logger {

    private String name;
    private levels level;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();

    public enum levels {
        DEBUG,
        INFO,
        WARNING,
        ERROR,
    }

    public Logger() {
        this.name = levels.DEBUG.toString();
        this.level = levels.DEBUG;

        loggers.put(this.name, this);
    }

    public Logger(String name) {
        this.name = name;
        loggers.put(this.name, this);
    }

    public Logger(String name, levels level) {
        this.name = name;
        this.level = level;
        loggers.put(this.name, this);
    }

    /*public void setName(String name) {
        this.name = name;
    }*/

    public void setLevel(levels level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public levels getLevel() {
        return this.level;
    }

    public static Logger getLogger(String name) {

        if (loggers.get(name) != null)
            return loggers.get(name);

        loggers.put(name, new Logger(name));
        return loggers.get(name);
    }

    public void debug(String message) {
        LogMessage(levels.DEBUG, message);
    }

    public void debug(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(levels.DEBUG, message);
    }

    public void info(String message) {
        LogMessage(levels.INFO, message);
    }

    public void info(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(levels.INFO, message);
    }

    public void warning(String message) {
        LogMessage(levels.WARNING, message);
    }

    public void warning(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(levels.WARNING, message);
    }

    public void error(String message) {
        LogMessage(levels.ERROR, message);
    }

    public void error(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(levels.ERROR, message);
    }

    public void LogMessage(levels level, String message) {
        //[WARNING] 2018.07.17 09:56:32 myLogger - something weird happened
        if (isLoggable(level) && level.ordinal() >= this.level.ordinal()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            Date date = new Date();
            String log = String.format("[%s] %s %s - %s", level.toString(), dateFormat.format(date), name, message);
            System.out.println(log);
        }
    }

    public boolean isLoggable(levels level) {
        return level != null;
    }

}
