package com.rafaeldeluca;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProgramNIO2 {

    private static final String FOLDER = "c:" + File.separator + "iofiles";
    private static final String FILE = FOLDER + File.separator + "file-nio2-example.txt";

    public ProgramNIO2() {
        try {
            File folder = new File(FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
                if (folder.exists()) {
                    System.out.println("Folder create with success!");
                }
            }
            writeFileUsingNIO2();
            System.out.println("\nReading fine using nio2");
            readFileUsingNIO2();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    private void writeFileUsingNIO2() throws IOException {

        StringBuilder nio2Content = new StringBuilder("Initial new input output file 2 data");
        nio2Content.append("\nSecond line using nio2 file");

        final Path path = Paths.get(FILE);
        Files.writeString(path, nio2Content);
        System.out.println("java.nio.file nio2 data write with success!");

    }

    private void readFileUsingNIO2 () throws IOException  {

        final Path path = Paths.get(FILE);
        // print a list of streams - print as a array
        System.out.println(Files.readAllLines(path));
        System.out.println("\n");
        // return stream using consumer - lazzy - more performatic
        Files.readAllLines(path).
                forEach(System.out::println);
    }

    public static void main(String[] args) {
        new ProgramNIO2();
    }

}
