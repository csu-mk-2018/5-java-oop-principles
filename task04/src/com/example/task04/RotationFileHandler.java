package com.example.task04;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

/**
 * Обработчик для вывода сообщений в файл с определенным интервалом
 */
public class RotationFileHandler implements MessageHandler {

    private final String path;
    private final String datePattern;
    private final ChronoUnit interval;
    private FileWriter writer;
    private LocalDateTime lastTimeFileCreation;

    /**
     * Конструктор RotationFileHandler
     * Файлы создаются с именем path_datePattern.txt
     *
     * @param path        путь до файла и/или начало его имени
     * @param datePattern шаблон даты в формате {@link java.text.SimpleDateFormat}
     * @param interval    временной интервал в формате {@link java.time.temporal.ChronoUnit}
     */
    public RotationFileHandler(String path, String datePattern, ChronoUnit interval) {
        if (path != null && datePattern != null && interval != null) {
            this.path = path;
            this.datePattern = datePattern;
            this.interval = interval;
            this.lastTimeFileCreation = LocalDateTime.now().truncatedTo(interval);
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void printMessage(String message) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        currentTime = currentTime.truncatedTo(interval);

        if (writer == null || currentTime.isAfter(lastTimeFileCreation)) {
            String fileName = String.format("%s_%s.txt", path, currentTime.format(DateTimeFormatter.ofPattern(datePattern)));
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            writer = new FileWriter(fileName);
            lastTimeFileCreation = currentTime;
        }
        writer.write(message);
        writer.flush();
    }
}
