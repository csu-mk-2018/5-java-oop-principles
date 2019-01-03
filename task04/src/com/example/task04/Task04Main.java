package com.example.task04;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Logger logger = Logger.getLogger("logger1");
        logger.addHandler(new ConsoleHandler());
        logger.addHandler(new MemoryHandler(new FileHandler("test.txt"), 5));
        logger.addHandler(new RotationFIleHandler(ChronoUnit.MINUTES, "LogsHere"));

        logger.debug("test message1");
        logger.info("test message1");
        logger.warning("test message1");
        logger.error("test message1");

        logger.log(Logger.Level.DEBUG, "test #1");
        logger.log(Logger.Level.DEBUG, "test #2");
        logger.log(Logger.Level.INFO, "test #3");
        logger.log(Logger.Level.DEBUG, "test #4");
        logger.log(Logger.Level.DEBUG, "test #5");

        Thread.sleep(60001);

        logger.log(Logger.Level.DEBUG, "test #6");
        logger.log(Logger.Level.DEBUG, "test #7");
        logger.log(Logger.Level.DEBUG, "test #8");
    }
}