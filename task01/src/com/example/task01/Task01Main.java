package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        logger1.setLevel(Logger.Level.DEBUG);
        logger1.debug("Debug message");
        logger1.info("Info message");
        logger1.warning("Warning message");
        logger1.error("Error message");
    }
}
