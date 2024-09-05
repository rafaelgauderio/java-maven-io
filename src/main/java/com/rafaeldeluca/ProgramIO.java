package com.rafaeldeluca;

import java.io.File;
import java.io.IOException;

public class ProgramIO {

    private static final String FOLDER = "c:" + File.separator + "iofiles";
    private static final String FILE = FOLDER + File.separator + "file-io-example.txt";

    public ProgramIO() {

        try {
            File folder = new File(FOLDER);
            File file = new File(FILE);
            if (folder.exists() == false) {
                folder.mkdir();
                System.out.println(folder.exists());
            }
            if (file.exists() == false) {
                file.createNewFile();
                System.out.println(file.exists());
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ProgramIO();
    }
}
