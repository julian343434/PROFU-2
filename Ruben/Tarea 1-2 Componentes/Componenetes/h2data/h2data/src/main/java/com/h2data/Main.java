package com.h2data;

import builder.FileRepository;
import facthory.DefaultFileRepository;
import facthory.FileFactory;
import org.h2.tools.Console;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");
        String filePath = "C:\\Users\\mayko\\OneDrive\\Escritorio\\" +
                "Uni 2023-2\\software2\\h2data\\src\\main\\resources" +
                "\\Certificate.pdf";
        String fileOutputPath = "C:\\Users\\mayko\\OneDrive\\Escritorio\\" +
                "Uni 2023-2\\software2\\h2data\\src\\main\\resources\\";
        FileFactory fileFactory = new DefaultFileRepository();
        FileRepository fileRepository = fileFactory.createFileRepository();
        Console.main();

        try{
            fileRepository.createTable();

            File file = new File(filePath);
            fileRepository.insertFile(1, "certificate.pdf", file);

            File retrieve = fileRepository.retrieveFile(1, fileOutputPath);
            System.out.println("Retrieved file: " + retrieve.getAbsolutePath());
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}