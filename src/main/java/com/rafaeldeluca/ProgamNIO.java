package com.rafaeldeluca;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ProgamNIO {

    private static final String FOLDER = "c:" + File.separator + "iofiles";
    private static final String FILE = FOLDER + File.separator + "file-nio-example.txt";

    //constructor
    public ProgamNIO() {
        try {
            File folder = new File(FOLDER);
            if (folder.exists() == false) {
                folder.mkdir();
                if (folder.exists()) {
                    System.out.println("Folder create with success!");
                }
            }
            writeFileNIO();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void writeFileNIO() throws IOException {

        final RandomAccessFile randomAccessFile = new RandomAccessFile(FILE, "rw");
        final FileChannel channel = randomAccessFile.getChannel();
        StringBuilder content = new StringBuilder("Initial new input output file data");
        content.append("\nSecond line nio file");
        channel.write(ByteBuffer.wrap(content.toString().getBytes(StandardCharsets.UTF_8)));
        channel.close();
        System.out.println("java.nio.file data write with success!");
    }

    public static void main(String[] args) {
        ProgamNIO progamNIO = new ProgamNIO();

    }
}