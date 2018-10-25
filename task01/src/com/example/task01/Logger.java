package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {
    private String name;
    private Level level = Level.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Logger(String name) {
        this.name = name;
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

    public void setName(String name) {
        loggers.remove(name);
        this.name = name;
        loggers.put(name, this);
    }

    private static Logger createLogger(String name) {
        Logger nLogger = new Logger(name);
        loggers.put(name, nLogger);
        return nLogger;
    }

    public static Logger getLogger(String name) {
        Logger logger = loggers.get(name);
        if (logger == null)
            return createLogger(name);
        else
            return logger;
    }

    public void log(Level level, String message) {
        if (this.level.ordinal()<=level.ordinal()) {
            printMess(level, message);
        }
    }

    public void log(Level level, String format, Object... varargs) {
        if (this.level.ordinal()<=level.ordinal()) {
            printMess(level, String.format(format, varargs));
        }
    }

    public void debug(String message) {
        if (this.level.ordinal()<=Level.DEBUG.ordinal()) {
            printMess(Level.DEBUG, message);
        }

    }

    public void debug(String format, Object... varargs) {
        if (this.level.ordinal()<=Level.DEBUG.ordinal()) {
            printMess(Level.DEBUG, String.format(format, varargs));
        }
    }

    public void info(String message) {
        if (this.level.ordinal()<=Level.INFO.ordinal()) {
            printMess(Level.INFO, message);
        }
    }

    public void info(String format, Object... varargs) {
        if (this.level.ordinal()<=Level.INFO.ordinal()) {
            printMess(Level.INFO, String.format(format, varargs));
        }
    }

    public void warning(String message) {
        if (this.level.ordinal()<=Level.WARNING.ordinal()) {
            printMess(Level.WARNING, message);
        }
    }

    public void warning(String format, Object... varargs) {
        if (this.level.ordinal()<=Level.WARNING.ordinal()) {
            printMess(Level.WARNING, String.format(format, varargs));
        }
    }

    public void error(String message) {
        if (this.level.ordinal()<=Level.ERROR.ordinal()) {
            printMess(Level.ERROR, message);
        }
    }

    public void error(String format, Object... varargs) {
        if (this.level.ordinal()<=Level.ERROR.ordinal()) {
            printMess(Level.ERROR, String.format(format, varargs));
        }
    }

    private void printMess(Level level, String message) {
        String dateStr = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        System.out.println(String.format("[%s] %s %s - %s", level, dateStr, name, message));
    }
}
