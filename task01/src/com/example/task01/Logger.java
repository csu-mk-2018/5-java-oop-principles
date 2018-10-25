package com.example.task01;

import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Logger {

    private final String Name;
    private Level level;

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
        this.level = Level.DEBUG;
    }

    public static Logger getLogger(String Name) {
        Logger logger = loggers.get(Name);
        if (logger != null)
            return logger;
        else
            return new Logger(Name);
    }

    private void ShowMessage(Level level, String message) {
        String dateStr = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        System.out.println(String.format("[%s] %s %s - %s", level, dateStr, Name, message));
    }

    public void debug(String message) {
        if (this.level.ordinal() <= Level.DEBUG.ordinal()) {
            ShowMessage(Level.DEBUG, message);
        }
    }

    public void debug(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.DEBUG.ordinal()) {
            ShowMessage(Level.DEBUG, String.format(format, varargs));
        }
    }

    public void info(String message) {
        if (this.level.ordinal() <= Level.INFO.ordinal()) {
            ShowMessage(Level.INFO, message);
        }
    }

    public void info(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.INFO.ordinal()) {
            ShowMessage(Level.INFO, String.format(format, varargs));
        }
    }

    public void warning(String message) {
        if (this.level.ordinal() <= Level.WARNING.ordinal()) {
            ShowMessage(Level.WARNING, message);
        }
    }

    public void warning(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.WARNING.ordinal()) {
            ShowMessage(Level.WARNING, String.format(format, varargs));
        }
    }

    public void error(String message) {
        if (this.level.ordinal() <= Level.ERROR.ordinal()) {
            ShowMessage(Level.ERROR, message);
        }
    }

    public void error(String format, Object... varargs) {
        if (this.level.ordinal() <= Level.ERROR.ordinal()) {
            ShowMessage(Level.ERROR, String.format(format, varargs));
        }
    }

    public void log(Level level, String message) {
        if (this.level.ordinal() <= level.ordinal()) {
            ShowMessage(level, message);
        }
    }

    public void log(Level level, String format, Object... varargs) {
        if (this.level.ordinal() <= level.ordinal()) {
            ShowMessage(level, String.format(format, varargs));
        }
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


}
