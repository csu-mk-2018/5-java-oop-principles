package com.example.task01;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
Уровни хранятся в виде чисел,
в методах используется это число
для получения имени уровня в виде String: levels[level]
*/

public class Logger {

    private String name;
    private int level;
    private static List<Logger> loggers = new ArrayList();
    private String[] levels = {"DEBUG", "INFO", "WARNING", "ERROR"};


    public Logger() {
        this.name = null;
        this.level = Integer.MAX_VALUE;

        loggers.add(this);
    }

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    public Logger(String name, int level) {
        this.name = name;
        this.level = level;
        loggers.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public String getLevel() {
        return levels[this.level];
    }

    public static Logger getLogger(String name) {
        for (Logger elem : loggers) {
            if (elem.name.equals(name))
                return elem;
        }

        return new Logger(name);
    }

    public void debug(String message) {
        LogMessage(0, message);
    }

    public void debug(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(0, message);
    }

    public void info(String message) {
        LogMessage(1, message);
    }

    public void info(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(1, message);
    }

    public void warning(String message) {
        LogMessage(2, message);
    }

    public void warning(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(2, message);
    }

    public void error(String message) {
        LogMessage(3, message);
    }

    public void error(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        LogMessage(3, message);
    }

    public void LogMessage(int level, String message) {
        //[WARNING] 2018.07.17 09:56:32 myLogger - something weird happened
        if (isLoggable(levels[level]) && level >= this.level) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            Date date = new Date();
            String log = String.format("[%s] %s %s - %s", levels[level], dateFormat.format(date), name, message);
            System.out.println(log);
        }
    }

    public boolean isLoggable(String level) {
        return level != null;
    }

}
