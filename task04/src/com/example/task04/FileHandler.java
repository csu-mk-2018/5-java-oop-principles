package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {

    private FileWriter writer;

    public FileHandler(String fileName) {
        setFile(fileName);
    }

    public void setFile(String fileName) {
        try {
            this.writer = new FileWriter(fileName, true);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void printMessage(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException ex) {
            (new ConsoleHandler()).printMessage(message + "\n ^^^^ this message not saved. FileHandler error");
        }
    }

}
