package org.example.fileData;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.annotations.IncludeInFile;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
public abstract class FileData {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dog implements Serializable {

        @IncludeInFile(name = "name")
        @CsvBindByName(column = "name")
        private String name;

        @IncludeInFile(name = "age")
        @CsvBindByName(column = "age")
        private int age;

        @IncludeInFile(name = "price")
        @CsvBindByName(column = "price")
        private float price;

        @IncludeInFile(name = "id")
        @CsvBindByName(column = "id")
        private UUID uuid;

        @IncludeInFile(name = "date")
        @CsvDate(value = "yyyy-MM-dd")
        @CsvBindByName(column = "date")
        private LocalDate date;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Car implements Serializable {

        @CsvBindByName(column = "model")
        @IncludeInFile(name = "model")
        private String model;

        @CsvBindByName(column = "year")
        @IncludeInFile(name = "year")
        private int year;

        @CsvBindByName(column = "price")
        @IncludeInFile(name = "price")
        private float price;

        @CsvBindByName(column = "id")
        @IncludeInFile(name = "id")
        private UUID uuid;

        @CsvBindByName(column = "extraFeatures")
        @IncludeInFile(name = "extraFeatures")
        private boolean extraFeatures;
    }
}
