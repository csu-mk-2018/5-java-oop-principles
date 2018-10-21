package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger0 = new Logger("test1");
        Logger logger1 = Logger.getLogger("test1");
        Logger logger2 = Logger.getLogger("test1");
        System.out.println(logger1 == logger2);

        logger0.debug("some message 1");
        logger0.info("some message 1");
        logger0.warning("some message 1");
        logger0.error("some message 1");

        System.out.println(logger0.getLevel());
        logger0.setLevel("warning");

        logger0.debug("some message 2");
        logger0.info("some message 2");
        logger0.warning("some message 2");
        logger0.error("some message 2");

        logger1.log("ERROR", "log error");
        logger2.log("error", "0x%x: %s", 0x1223, "log debug");
    }
}
