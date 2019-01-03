package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.*;
import java.time.temporal.ChronoUnit;

public class RotationFIleHandler implements MessageHandler {

    private ChronoUnit timeInterval;
    private String path;
    private FileWriter writer;
    private LocalDateTime lastTimeFileCreated;

    public RotationFIleHandler(ChronoUnit timeInterval, String path) {

        this.timeInterval = timeInterval;
        this.path = path;
    }

    @Override
    public void PrintMessage(String message) throws IOException {

        LocalDateTime currentTime = LocalDateTime.now();
        currentTime = currentTime.truncatedTo(timeInterval);

        if (writer == null || currentTime.isAfter(lastTimeFileCreated)) {
            String fileName = path + currentTime.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm")) + ".txt";
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            writer = new FileWriter(fileName);
            lastTimeFileCreated = currentTime;
        }
        writer.write(message);
        writer.flush();
    }
}
