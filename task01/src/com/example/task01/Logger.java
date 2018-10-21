package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {
    private final String name;
    private Level level = Level.DEBUG;
    private static ArrayList<Logger> loggers = new ArrayList<>();

    private static enum Level {
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARNING("WARNING"),
        ERROR("ERROR");

        private String value;

        private Level(String value) {
            this.value = value;
        }

        private static Level fromString(String value) {
            if (value != null) {
                for (Level lvl : Level.values()) {
                    if (value.equalsIgnoreCase(lvl.value)) {
                        return lvl;
                    }
                }
            }
            throw new IllegalArgumentException("No such value");
        }
    }

    public Logger(String name) {
        this.name = name;
        loggers.add(this);
    }

    public String getName() {
        return name;
    }

    public void error(String msg) {
        log(Level.ERROR.toString(), msg);
    }

    public void error(String format, Object... varargs) {
        log(Level.ERROR.toString(), String.format(format, varargs));
    }

    public void warning(String msg) {
        log(Level.WARNING.toString(), msg);
    }

    public void warning(String format, Object... varargs) {
        log(Level.WARNING.toString(), String.format(format, varargs));
    }

    public void info(String msg) {
        log(Level.INFO.toString(), msg);
    }

    public void info(String format, Object... varargs) {
        log(Level.INFO.toString(), String.format(format, varargs));
    }

    public void debug(String msg) {
        log(Level.DEBUG.toString(), msg);
    }

    public void debug(String format, Object... varargs) {
        log(Level.DEBUG.toString(), String.format(format, varargs));
    }

    public void log(String level, String message) {
        if (Level.fromString(level).ordinal() >= this.level.ordinal()) {
            String dateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
            System.out.println(String.format("[%s] %s %s - %s", Level.fromString(level), dateNow, name, message));
        }
    }

    public void log(String level, String format, Object... varargs) {
        log(level, String.format(format, varargs));
    }

    public static Logger getLogger(String name) {
        for (Logger i : loggers) {
            if (i.getName().equals(name))
                return i;
        }
        return null;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = Level.fromString(level);
    }
}
