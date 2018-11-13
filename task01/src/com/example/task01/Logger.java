package com.example.task01;

import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {

    private final String Name;
    private Level level;
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private static HashMap<String, Logger> loggers = new HashMap();


    public String getName() {
        return Name;
    }

    private Logger(String Name) {
        this.Name = Name;
        loggers.put(Name, this);
    }

    public static Logger getLogger(String Name) {
        Logger logger = loggers.get(Name);
        if (logger != null)
            return logger;
        else
            return new Logger(Name);
    }

    private void showMessage(Level level, String message) {
        String dateStr = DATE_FORMAT.format(new Date());
        System.out.println(String.format("[%s] %s %s - %s", level, dateStr, Name, message));
    }

    public void debug(String message) {
        if (this.level.ordinal() <= Level.DEBUG.ordinal()) {
            showMessage(Level.DEBUG, message);
        }
    }

    public void debug(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.DEBUG.ordinal()) {
            showMessage(Level.DEBUG, String.format(format, varargs));
        }
    }

    public void info(String message) {
        if (this.level.ordinal() <= Level.INFO.ordinal()) {
            showMessage(Level.INFO, message);
        }
    }

    public void info(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.INFO.ordinal()) {
            showMessage(Level.INFO, String.format(format, varargs));
        }
    }

    public void warning(String message) {
        if (this.level.ordinal() <= Level.WARNING.ordinal()) {
            showMessage(Level.WARNING, message);
        }
    }

    public void warning(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.WARNING.ordinal()) {
            showMessage(Level.WARNING, String.format(format, varargs));
        }
    }

    public void error(String message) {
        if (this.level.ordinal() <= Level.ERROR.ordinal()) {
            showMessage(Level.ERROR, message);
        }
    }

    public void error(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.ERROR.ordinal()) {
            showMessage(Level.ERROR, String.format(format, varargs));
        }
    }

    public void log(Level level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            showMessage(level, message);
        }
    }

    public void log(Level level, String format, Object... varargs) {
        if (this.level.ordinal() <= level.ordinal()) {
            showMessage(level, String.format(format, varargs));
        }
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


}
