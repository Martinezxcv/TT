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
                return new CsvFileManager();
            }
            case 2 -> {
                return new JsonFileManager();
            }
            case 3 -> {
                return new XlsxFileManager();
            }
            case 4 -> {
                return new XmlFileManager();
            }
            case 5 -> {
               return new YamlFileManager();
            }
            default -> System.out.println("Invalid filetype!");
        }
        return null;
    }

    public void selectOperation(int file, int operation, int data) throws Exception {
        if(!selectData(data).isEmpty()) {
            if (operation == 1)
                Objects.requireNonNull(selectFiletype(file)).saveToFile(selectData(data),
                        "C:\\Users\\mmazurek\\Desktop\\pliki\\"
                                + Objects.requireNonNull(selectData(data)).get(0).getClass().getSimpleName()
                                + Objects.requireNonNull(selectFiletype(file)).getFileExtension());
            else if (operation == 2)
                Objects.requireNonNull(selectFiletype(file)).readFromFile(selectData(data),
                        "C:\\Users\\mmazurek\\Desktop\\pliki\\"
                                + Objects.requireNonNull(selectData(data)).get(0).getClass().getSimpleName()
                                + Objects.requireNonNull(selectFiletype(file)).getFileExtension());
            else
                System.out.println("Invalid operation type!");
        }
        else System.out.println("Empty data!");
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
