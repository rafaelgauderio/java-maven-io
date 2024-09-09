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
            System.out.println("\nReading file with java.nio.file");
            readFileNIO();
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

    private void readFileNIO() throws IOException {
        final RandomAccessFile randomAccessFile = new RandomAccessFile(FILE, "r");
        final FileChannel fileChannel = randomAccessFile.getChannel();
        final long fileChannelSize = fileChannel.size();
        // converte long to integer and store on a ByteBuffer
        final ByteBuffer byteBuffer = ByteBuffer.allocate(Math.toIntExact(fileChannelSize));

        fileChannel.read(byteBuffer);
        // reverse to the initial of the file
        byteBuffer.flip();
       for(int i=0; i < fileChannelSize; i++) {
           System.out.print((char)byteBuffer.get());
       }
       fileChannel.close();
       randomAccessFile.close();

    }

    public static void main(String[] args) {
        ProgamNIO progamNIO = new ProgamNIO();


    }
}