package com.example.task04;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

public class RotationFileHandler implements MessageHandler {

    private final String pathPattern;
    private final String fileNamePattern;
    private final ChronoUnit interval;
    private FileWriter writer;
    private LocalDateTime lastTimeFileCreation;

    public RotationFileHandler(String pathPattern, String fileNamePattern, ChronoUnit interval) {
        this.pathPattern = pathPattern;
        this.fileNamePattern = fileNamePattern;
        this.interval = interval;
        this.lastTimeFileCreation = LocalDateTime.now().truncatedTo(interval);
    }

    @Override
    public void printMessage(String message) {
        LocalDateTime currentTime = LocalDateTime.now();
        currentTime = currentTime.truncatedTo(interval);

        if (writer == null || currentTime.isAfter(lastTimeFileCreation)) {
            String fileName = String.format("%s_%s.txt", pathPattern, currentTime.format(DateTimeFormatter.ofPattern(fileNamePattern)));
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
                writer = new FileWriter(fileName);
                lastTimeFileCreation = currentTime;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException ex) {
            (new ConsoleHandler()).printMessage(message + "\n ^^^^ this message not saved. RotationFileHandler error");
        }
    }
}
