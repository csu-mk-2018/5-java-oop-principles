package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger fLogger = Logger.getLogger("test1");
        Logger sLogger = Logger.getLogger("test2");
        Logger afLogger = Logger.getLogger("test1");

        if (fLogger == afLogger) {
            System.out.println("One instance of fLogger!");
        }

        System.out.println(fLogger.getLevel());
        fLogger.setLevel(ImportanceLevel.WARNING);
        System.out.println(fLogger.getLevel());

        fLogger.warning("some message");
        fLogger.warning("%d %d %s", 4, 5, "some !");

        fLogger.debug("will not printed");
        sLogger.debug("will be printed");

        fLogger.log("message info not printed", ImportanceLevel.INFO);
        fLogger.log("message info is printed", ImportanceLevel.ERROR);

        fLogger.log("formatted %d %d %f", ImportanceLevel.WARNING, 4, 7, 2.5);

    }
}
