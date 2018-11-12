package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {

    private FileWriter writer;
    public FileHandler(String puth) throws Exception {
        this.writer = new FileWriter(puth);
    }

    public void sendMessage(String message) throws Exception {
        this.writer.write(message);
        this.writer.flush();
    }
}
