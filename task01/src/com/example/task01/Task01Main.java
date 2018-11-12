package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger0;
        logger0 = new Logger("test");
        Logger logger1 = Logger.getLogger("test");
        System.out.println(logger0 == logger1);
        logger0.debug("test debug");
        logger0.info("test information");
        logger0.warning("test warning");
        logger0.error("test error");
    }
}
