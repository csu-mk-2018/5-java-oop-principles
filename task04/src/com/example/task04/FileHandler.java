package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private FileWriter writer;

    public FileHandler(String fileName) throws IOException {

        writer = new FileWriter(fileName, true);
    }

    @Override
    public void PrintMessage(String message) throws IOException {

        writer.write(message);
        writer.flush();
    }
}
