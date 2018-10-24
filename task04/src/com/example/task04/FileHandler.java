package com.example.task04;

import java.io.*;

import java.io.FileWriter;

public class FileHandler {

    private final String puthToFile;

    public FileHandler(String puth) {
        this.puthToFile = puth;
    }

    /*
     Метод принимает первым параметром сообщение логгера,
     вторым параметром - флаг, указывающий на перезапись или дозапись в конец файла
     true = дозапись, false = перезапись файла
     */
    public void sendMessage(String message, boolean append) {

        try (FileWriter writer = new FileWriter(puthToFile, append)) {
            writer.write(message);
            writer.flush();
            writer.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
