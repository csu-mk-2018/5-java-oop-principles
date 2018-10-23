package com.example.task04;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class RotationFileHandler implements MessageHandler {

    private final String filePattern;
    private final String fileName;
    private FileWriter writer;

    private final ChronoUnit interval;
    private LocalDateTime currentTime;

    public RotationFileHandler(String fileName, String filePattern, ChronoUnit interval) {
        this.filePattern = filePattern;
        this.interval = interval;
        this.fileName = fileName;
    }

    @Override
    public void printMessage(String message) {
        LocalDateTime date = LocalDateTime.now();
        date = date.truncatedTo(interval);
        if (writer == null || !currentTime.equals(date)) {
            String curFileName = fileName + "_"
                    + date.format(DateTimeFormatter.ofPattern(filePattern)) + ".log";
            try {

                if (writer != null) {
                    writer.flush();
                    writer.close();
                }

                writer = new FileWriter(curFileName);
                currentTime = date;
            } catch (IOException e) {
                return;
            }
        }

        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            return;
        }
    }
}
