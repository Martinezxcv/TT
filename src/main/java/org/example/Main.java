package org.example;

import org.example.fileManager.FileManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        FileManager fileManager = new FileManager();
        while (true) {
            System.out.print("""
                    Please, select data :
                    1 - Dogs
                    2 - Cars 
                    """);
            int data = Integer.parseInt(reader.readLine());
            System.out.print("""
                    Please, select a filetype:
                    1 - CSV
                    2 - JSON
                    3 - XLSX
                    4 - XML
                    5 - YAML
                    """);
            int file = Integer.parseInt(reader.readLine());
            System.out.print("""
                    Please, select an operation:
                    1 - save
                    2 - read
                    """);
            int operation = Integer.parseInt(reader.readLine());
            fileManager.selectOperation(file, operation,data);
        }
    }
}