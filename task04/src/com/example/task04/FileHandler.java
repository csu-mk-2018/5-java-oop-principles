package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {

    private FileWriter writer;
    private String path;
    private boolean append;

    public FileHandler(String path) throws Exception {
        if (path == null)
            throw new IllegalAccessException("Неверно задан путь до файла!");
        this.path = path;
        this.append = true;
        this.writer = new FileWriter(this.path, append);
    }

    public void sendMessage(String message) throws Exception {
        this.writer.write(message + "\n");
        this.append = false;
        this.writer.close();
    }
}
