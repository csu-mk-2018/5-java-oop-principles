package com.example.task04;

import java.time.LocalDateTime;


public class Task04Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        logger1.setLevel(Logger.Level.DEBUG);
        logger1.setHandler(Logger.Handler.ROTATIONFILE);
        logger1.debug("DebugMessage");

        logger1.setHandler(Logger.Handler.MEMORY);
        for (int i = 0; i < 100; i++)
            logger1.debug("debugMessage");

        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        System.out.println(minute);
    }
}
