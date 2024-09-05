package com.rafaeldeluca;

import java.io.*;
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
            if (folder.exists() && file.exists()) {
                final OutputStream outputStream = new FileOutputStream(file);
                String content = "Initial file inside data";
                content = content.concat("\nSecond line file content");
                outputStream.write(content.getBytes("UTF-8"));
                outputStream.close();
                System.out.println("file data write with success!");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void readFile() {
        // 1 byte = 8 bits
        // 1 char UFT-8  = 1 byte
        // 1 char UFT-16 = 2 bytes

        //InputStream inputStream = null;
        try {
            final InputStream inputStream = new FileInputStream(FILE);
            int fileContent;
            while ((fileContent = inputStream.read()) != -1) {
                System.out.print((char) fileContent);
            }

        } catch (IOException ioexception) {
            ioexception.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ProgramIO programIO = new ProgramIO();
        programIO.writeFile();
        programIO.readFile();
    }
}
