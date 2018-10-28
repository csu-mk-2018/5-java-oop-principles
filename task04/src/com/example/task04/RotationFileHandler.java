package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {

    private String puthPattern;
    private long currentTime;
    private int intervalInMin;
    private boolean append;

    RotationFileHandler(int interval) {
        this.intervalInMin = interval;
        this.currentTime = -1;
    }

    /*
    Выводит сообщения с интервалом в intervalInMin в минутах. Если текущая минута <= чем предыдущая
    сохраненная + интервал дописывает в конец текущего файла (append = false), иначе - перезаписывает путь и append
     */

    public void sendMessage(String message) {
        LocalDateTime now = LocalDateTime.now();
        int currentTimePeriod = now.getMinute();

        //Если было например, 59 минут, запомнили 59 минут, затем стало 0 минут, перезапываем
        //данные, иначе условия больше не выполнятся
        if(this.currentTime > currentTimePeriod)
            this.currentTime = -1;

        this.puthPattern = String.format("log.%s", now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm")));
        this.append = false;
        if (currentTimePeriod > this.currentTime + this.intervalInMin) {
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
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}
