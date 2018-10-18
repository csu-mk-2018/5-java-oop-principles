package com.example.task01;

import java.util.*;
import java.text.*;

public class Logger {
    private String name;
    private int level;

    private static ArrayList<Logger> loggers = new ArrayList<>();
    private ArrayList<String> messages = new ArrayList<>();

    private String levels[] = {"debug", "info", "warning", "error"};


    Logger(String name) {
        this.name = name;
        this.level = 0;
        loggers.add(this);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static Logger getLogger(String name) {
        for (Logger i : loggers) {
            if (i.getName() == name) {
                return i;
            }
        }
        return new Logger(name);
    }

    public void setLevel(String level) {
        int checkSetLevel=0;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == level)
                this.level = i;
            else
                checkSetLevel++;
        }
        if(checkSetLevel==levels.length)
            System.out.println("Невозможно задать логгеру уровень важности: " + level);
    }

    public int getLevel() {
        return this.level;
    }

    public void debug(String message) {
        if (this.level == 0) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[DEBUG] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + message;
            System.out.println(mes);
            //messages.add(mes);
        }
    }

    public void debug(String format, Object... message) {
        if (this.level == 0) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[DEBUG] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + String.format(format, message);
            System.out.println(mes);
            //messages.add(mes);
        }
    }

    public void info(String message) {
        if (this.level < 2) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[INFO] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + message;
            System.out.println(mes);
            //messages.add(mes);
        }
    }

    public void info(String format, Object... message) {
        if (this.level < 2) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[INFO] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + String.format(format, message);
            System.out.println(mes);
            //messages.add(mes);
        }
    }

    public void warning(String message) {
        if (this.level < 3) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[WARNING] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + message;
            System.out.println(mes);
            //messages.add(mes);
        }
    }

    public void warning(String format, Object... message) {
        if (this.level < 3) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            String mes = "[WARNING] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + String.format(format, message);
            System.out.println(mes);
            messages.add(mes);
        }
    }

    public void error(String message) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
        String mes = " [ERROR] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + message;
        System.out.println(mes.trim());
        messages.add(mes);
    }

    public void error(String format, Object... message) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
        String mes = " [ERROR] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + String.format(format, message);
        System.out.println(mes.trim());
        messages.add(mes);
    }

    public String log(String level, String message) {
        int levelOfLog = 100;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == level) {
                levelOfLog = i;
            }
        }
        if (this.level <= levelOfLog) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
            String mes = " [" + level.toUpperCase() + "]" + " " + formatForDateNow.format(dateNow) + " " + this.name + " - " + message;
            System.out.println(mes.trim());
            return mes;
        }
        return null;
    }

    public String log(String level, String format, Object... message) {
        int levelOfLog = 100;
        for (int i = 0; i < levels.length; i++) {
            if (levels[i] == level)
                levelOfLog = i;
        }
        if (this.level >= levelOfLog) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("YYYY.MM.dd hh:mm:ss");
            String mes = " [" + level.toUpperCase() + "] " + formatForDateNow.format(dateNow) + " " + this.name + " - " + String.format(format, message);
            System.out.println(mes);
            messages.add(mes.trim());
            return mes;
        }
        return null;
    }

    public void printAllLogs() {
        for (String i : this.messages
                ) {
            System.out.println(i);
        }
    }
}
