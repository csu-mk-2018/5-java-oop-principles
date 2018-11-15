package com.example.task04;


import java.io.*;

public class FileHandler implements MessageHandler {

    private final FileWriter writer;

    public FileHandler(String fileName) {
        try {
            writer = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printMessage(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            return;
        }
    }

}
