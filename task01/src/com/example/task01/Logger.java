package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Logger {
    private Level level;
    private String name;

    public enum Level { DEBUG, INFO, WARNING, ERROR;
        @Override
        public String toString() {
            switch (this) {
                case DEBUG: return "DEBUG";
                case INFO: return "INFO";
                case WARNING: return "WARNING";
                case ERROR: return "ERROR";
                default: return super.toString();
            }
        }

        public int toInt() {
            switch (this) {
                case DEBUG: return 0;
                case INFO: return 1;
                case WARNING: return 2;
                case ERROR: return 3;
                default: return -1;
            }
        }
    }

    private static ArrayList<Logger> loggers = new ArrayList();

    public Logger(String name) {
        this.name = name;
        this.level = Level.DEBUG;
    }

    public Logger(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Logger) {
            return this.name.equals(((Logger) obj).getName()) && this.level == ((Logger) obj).getLevel();
        } else {
            return false;
        }
    }

    public static Logger getLogger(String name) {
        Logger logger = new Logger(name);
        if (loggers.contains(logger)) {
            return loggers.get(loggers.indexOf(logger));
        } else {
            loggers.add(logger);
        }
        return logger;
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
        String dateStr = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date());
        System.out.println(String.format("[%s] %s %s - %s", level, dateStr, name, message));
    }

    private boolean checkLevel(Level level) {
        return level.toInt() >= this.level.toInt();
    }

    public Level getLevel() { return level; }
    public void setLevel(Level level) { this.level = level; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
