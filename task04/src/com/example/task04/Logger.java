package com.example.task04;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Logger {
    private final String name;
    private final String lineSeparator = System.getProperty("line.separator");
    private Level level = Level.DEBUG;
    private static HashMap<String, Logger> loggers = new HashMap<>();
    private ArrayList<MessageHandler> handlers = new ArrayList<>();

    public static enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    private Logger(String name) {

        this.name = name;
        loggers.put(name, this);
    }

    public String getName() {

        return name;
    }

    public static Logger getLogger(String name) {

        Logger logger = loggers.get(name);
        if (logger == null) {
            logger = new Logger(name);
        }
        return logger;
    }

    public Level getLevel() {

        return level;
    }

    public void setLevel(Level level) {

        this.level = level;
    }

    public void addHandler(MessageHandler handler) {

        handlers.add(handler);
    }

    public void error(String msg) throws IOException {

        log(Level.ERROR, msg);
    }

    public void error(String format, Object... varargs) throws IOException {

        log(Level.ERROR, String.format(format, varargs));
    }

    public void warning(String msg) throws IOException {

        log(Level.WARNING, msg);
    }

    public void warning(String format, Object... varargs) throws IOException {

        log(Level.WARNING, String.format(format, varargs));
    }

    public void info(String msg) throws IOException {

        log(Level.INFO, msg);
    }

    public void info(String format, Object... varargs) throws IOException {

        log(Level.INFO, String.format(format, varargs));
    }

    public void debug(String msg) throws IOException {

        log(Level.DEBUG, msg);
    }

    public void debug(String format, Object... varargs) throws IOException {

        log(Level.DEBUG, String.format(format, varargs));
    }

    public void log(Level level, String message) throws IOException {

        if (level.ordinal() >= this.level.ordinal()) {
            String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            for (MessageHandler handler : handlers) {
                handler.PrintMessage(String.format("[%s] %s %s - %s%s", level, dateNow, name, message, lineSeparator));
            }
        }
    }

    public void log(Level level, String format, Object... varargs) throws IOException {

        log(level, String.format(format, varargs));
    }

}