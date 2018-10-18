package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger0 = new Logger("test");

        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);

        logger0.setLevel("warning");
        logger0.debug("test debug");
        logger0.info("test information");
        logger0.warning("test warning");
        logger0.error("test error");
        logger0.log("debug","test log.debug");
        logger0.log("error","test log.error");


        //[ERROR] YYYY.MM.DD hh:mm:ss test - test message
        //[ERROR] 2018.10.15 10:01:34 test - test message
    }
}
