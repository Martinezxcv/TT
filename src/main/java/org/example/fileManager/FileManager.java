package org.example.fileManager;

import org.example.fileData.CarList;
import org.example.fileData.DogList;
import org.example.filetypes.*;
import org.example.interfaces.FiletypeStrategy;

import java.util.List;
import java.util.Objects;

public class FileManager {

    private FiletypeStrategy selectFiletype(int file) {
        switch (file) {
            case 1 -> {
                return new CsvFile();
            }
            case 2 -> {
                return new JsonFile();
            }
            case 3 -> {
                return new XlsxFile();
            }
            case 4 -> {
                return new XmlFile();
            }
            case 5 -> {
               return new YamlFile();
            }
            default -> System.out.println("Invalid filetype!");
        }
        return null;
    }

    public void selectOperation(int file, int operation, int data) throws Exception {
        if (operation == 1)
            Objects.requireNonNull(selectFiletype(file)).saveToFile(selectData(data));
        else if (operation == 2)
            Objects.requireNonNull(selectFiletype(file)).readFromFile(selectData(data));
        else
            System.out.println("Invalid operation type!");
    }

    private List selectData(int data) {
        switch (data) {
            case 1 -> {
                return  new DogList().getDogList();
            }
            case 2 -> {
                return  new CarList().getCarList();
            }
        }
        return null;
    }
}
