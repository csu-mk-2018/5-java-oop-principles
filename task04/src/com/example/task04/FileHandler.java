package com.example.task04;

import java.io.*;

import java.io.FileWriter;

public class FileHandler implements MessageHandler {

    private final String puthToFile;

    public FileHandler(String puth) {
        this.puthToFile = puth;
    }

    /*
    Метод выводит сообщение в файл
     */
    public void sendMessage(String message) {

        try (FileWriter writer = new FileWriter(puthToFile)) {
            writer.write(message);
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

    }
}
