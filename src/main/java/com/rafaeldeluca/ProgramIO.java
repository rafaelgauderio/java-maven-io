package com.rafaeldeluca;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class ProgramIO {

    private static final String FOLDER = "c:" + File.separator + "iofiles";
    private static final String FILE = FOLDER + File.separator + "file-io-example.txt";


    public ProgramIO() {

    }

    private void writeFile() {

        try {
            File folder = new File(FOLDER);
            File file = new File(FILE);
            if (folder.exists() == false) {
                folder.mkdir();
                if (folder.exists()) {
                    System.out.println("Folder create with success!");
                }
            }
            if (file.exists() == false) {
                file.createNewFile();
                if (file.exists()) {
                    System.out.println("File create with sucess!");
                }
            }
            final OutputStream outputStream = new FileOutputStream(file);
            String content = "Initial file inside data";
            outputStream.write(content.getBytes("UTF-8"));
            outputStream.close();
            System.out.println("file data write with success!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new ProgramIO().writeFile();
    }
}
