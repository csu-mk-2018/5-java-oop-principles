package com.example.task04;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Logger {

    private final String name;
    private Level level;
    private Handler handler;
    private static Map<String, Logger> loggers = new HashMap<String, Logger>();

    public enum Level {
        DEBUG,
        INFO,
        WARNING,
        ERROR
    }

    public enum Handler {
        CONSOLE,
        FILE,
        ROTATIONFILE,
        MEMORY;

        public void write(String message) {
            switch (this) {
                case CONSOLE:
                    ConsoleHandler console = new ConsoleHandler();
                    console.sendMessage(message);
                    break;
                case FILE:
                    //Здесь лучше бы хранить поля puth и append, чтобы пользователь
                    //сам мог задать путь и флаг (дозапись или перезапись файла)
                    //не могу придумать где хранить эти поля, в классе Logger явно нет
                    FileHandler file = new FileHandler("log.txt");
                    file.sendMessage(message, true);
                    break;
                case ROTATIONFILE:
                    RotationFileHandler rotationFile = new RotationFileHandler();
                    rotationFile.sendMessage(message);
                    break;
                case MEMORY:
                    MemoryHandler memoryHandler = new MemoryHandler();
                    memoryHandler.SendMessage(message);
                    break;
            }
        }
    }

    public Logger(String name) {
        this.name = name;
        loggers.put(this.name, this);
    }

    private Logger(String name, Level level) {
        this.name = name;
        this.level = level;
        loggers.put(this.name, this);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public Level getLevel() {
        return this.level;
    }

    public static Logger getLogger(String name) {

        Logger temp = loggers.get(name);
        if (temp != null)
            return temp;

        temp = loggers.put(name, new Logger(name));
        return temp;
    }

    public void debug(String message) {
        logMessage(Level.DEBUG, message);
    }

    public void debug(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.DEBUG, message);
    }

    public void info(String message) {
        logMessage(Level.INFO, message);
    }

    public void info(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.INFO, message);
    }

    public void warning(String message) {
        logMessage(Level.WARNING, message);
    }

    public void warning(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.WARNING, message);
    }

    public void error(String message) {
        logMessage(Level.ERROR, message);
    }

    public void error(String strFormat, Object... args) {
        String message = String.format(strFormat, args);
        logMessage(Level.ERROR, message);
    }

    public void logMessage(Level level, String message) {
        //[WARNING] 2018.07.17 09:56:32 myLogger - something weird happened
        if (level != null && level.ordinal() >= this.level.ordinal()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            Date date = new Date();
            String log = String.format("[%s] %s %s - %s", level.toString(), dateFormat.format(date), name, message);
            this.handler.write(log);
        }
    }

}