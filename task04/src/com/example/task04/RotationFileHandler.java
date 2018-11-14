package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private int lastTimeMinutes;
    private int intervalInMin;
    private boolean append;
    private FileWriter writer;
    final private int NUMBER_MINUTES_IN_HOUR = 60;
    /**
     * Конструтор класса RotationFileHandler
     * @param interval интервал для вывода ссобщений в минутах
     */
    public RotationFileHandler(int interval) throws Exception {
        if (interval < 1)
            throw  new IllegalAccessException("Неверно задан интервал в минутах!");
        this.intervalInMin = interval;
    }

    /**
     * Метод выводит сообщения в файл с некоторым интервалом intervalInMin
     */
    public void sendMessage(String message) throws Exception {
        LocalDateTime now = LocalDateTime.now(); //Получаем текущее время
        int currentTimeMinutes = now.getMinute(); //Сохраняем минуты текущего часа

        //По умолчанию выводим в текущий файл
        this.append = false;

        //Если текущее локальное количество минут больше, чем (предыдущее + interval) % 60
        //Ставим предыдущим - текущее количество минут, и меняем флаг для создания нового
        //файла по вышеприведенному формату
        if (currentTimeMinutes >= (this.lastTimeMinutes + this.intervalInMin) % NUMBER_MINUTES_IN_HOUR) {
            this.lastTimeMinutes = currentTimeMinutes;
            //Путь до файла, куда выводить сообщение в формате: log.2018.11.12.22.40
            this.path = String.format("log.%s", now.format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm")));
            this.append = true;
        }

        //Вызываем метод записи, который в зависимости от флага append либо пишет в текущий файл
        //либо создает новый
        this.writerMessage(this.path, message, append);
    }

    /**
     * Конструтор класса RotationFileHandler
     * @param puth путь к файлу, куда выводить собщение
     * @param message выводимое сообщение
     * @param append флаг вывода. True  - в новый файл, false - в текущий файл
     */
    private void writerMessage(String puth, String message, boolean append) throws IOException {
        this.writer = new FileWriter(puth, append);
        writer.write(message + "\n");
        writer.flush();
    }
}
