package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler {

    private String puthPattern;
    private long currentTime;
    private boolean append;


    /*
    Выводит сообщения с интервалом в 1 минуту. Если минута текущего интервала не прошла, дописывает
    в конец текущего файла (append = false), иначе - перезаписывает путь и append
     */
    public void sendMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        int currentTimePeriod = now.getMinute();
        this.puthPattern = String.format("log.%s", now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm")));
        this.append = false;
        if (currentTimePeriod > this.currentTime) {
            this.currentTime = currentTimePeriod;
            this.puthPattern = String.format("log.%s", now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm")));
            this.append = true;
        }

        this.writerMessage(this.puthPattern, message, append);
    }

    /*
    Вспомогательная функция для вывода данных
    На входе: путь до файла, сообщение и флаг (дозапись или перезапись)
     */
    private void writerMessage(String puth, String message, boolean append) {
        try (FileWriter writer = new FileWriter(puth, append)) {
            writer.write(message + "\n");
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
