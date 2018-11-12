package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {

    private String puth;
    private long currentTime;
    private int intervalInMin;
    private boolean append = false;

    /**
     * Конструтор класса RotationFileHandler
     * @param interval интервал для вывода ссобщений в минутах
     */
    public RotationFileHandler(int interval) throws Exception {
        this.intervalInMin = interval;
        this.currentTime = -1;
    }

    /**
     * Метод выводит сообщения в файл с некоторым интервалом intervalInMin
     */
    public void sendMessage(String message) throws Exception {
        LocalDateTime now = LocalDateTime.now(); //Получаем текущее время
        int currentTimePeriod = now.getMinute(); //Сохраняем минуты текущего сайта

        //Если было например, 59 минут, запомнили 59 минут, затем стало 0 минут, перезапываем
        //данные, иначе условия больше не выполнятся
        if(this.currentTime > currentTimePeriod)
            this.currentTime = -1;

        //Путь до файла, куда выводить сообщение в формате: log.2018.11.12.22.40
        this.puth = String.format("log.%s", now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm")));

        //Если текущее локальное количество минут больше, чем предыдущее + interval
        //Ставим предыдущим - текущее количество минут, и меняем флаг для создания нового
        //файла по вышеприведенному формату.
        if (currentTimePeriod > this.currentTime + this.intervalInMin) {
            this.currentTime = currentTimePeriod;
            this.append = true;
        }

        //Вызываем метод записи, который в зависимости от флага append либо пишет в текущий файл
        this.writerMessage(this.puth, message, append);
    }

    /**
     * Конструтор класса RotationFileHandler
     * @param puth путь к файлу, куда выводить собщение
     * @param message выводимое сообщение
     * @param append флаг вывода. True  - в новый файл, false - в текущий файл
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
