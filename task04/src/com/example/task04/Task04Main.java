package com.example.task04;

import java.time.LocalDateTime;


public class Task04Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        logger1.setLevel(Logger.Level.DEBUG);
        logger1.setHandler(new ConsoleHandler());
        logger1.debug("DebugMessage");

        Logger logger2 = Logger.getLogger("Error");
        logger2.setLevel(Logger.Level.ERROR);
        logger2.setHandler(new MemoryHandler());
        for (int i = 0; i < 15; i++) {
            logger2.error("errorMessage");
        }

        Logger logger3 = Logger.getLogger("INFOmessage");
        logger3.setLevel(Logger.Level.INFO);
        logger3.setHandler(new RotationFileHandler(1));
        logger3.info("message");

        logger3.setHandler(new FileHandler("filehandler.txt"));
        logger3.info("testmessage");

        LocalDateTime now = LocalDateTime.now();
        int minute = now.getMinute();
        System.out.println(minute);
    }
}
