package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("log1", new ConsoleHandler());
        logger.log("message 1!!", ImportanceLevel.DEBUG);

        Logger test11 = Logger.getLogger("testlog");
        test11.debug("test with no handlers");

        logger.addHandler(new ConsoleHandler());
        logger.log("message 1!!", ImportanceLevel.DEBUG);

        Logger fileLogger = Logger.getLogger("log2", new FileHandler("C:/data_logs/log_file.txt"));
        fileLogger.log("message 2!!", ImportanceLevel.DEBUG);
        fileLogger.log("Error occured, check!", ImportanceLevel.ERROR);

        Logger fileRotationLogger = Logger.getLogger("log3", new RotationFileHandler("C:/data_logs/log", "yyyy_MM_dd_hh.mm", ChronoUnit.MINUTES));
        fileRotationLogger.log("LOG ME!!", ImportanceLevel.ERROR);

        Logger memoryLogger = Logger.getLogger("log4", new MemoryHandler(3, new ConsoleHandler()));
        memoryLogger.debug("1");
        memoryLogger.debug("2");
        memoryLogger.debug("3");
        memoryLogger.debug("4");
    }
}
