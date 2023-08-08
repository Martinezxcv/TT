package org.example.fileData;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.interfaces.FiletypeStrategy;
import org.example.annotations.DBClass;
import org.example.annotations.DBField;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
public abstract class FileData implements FiletypeStrategy {
    @Data
    @DBClass
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Dog implements Serializable {
        @DBField(name = "name")
        @CsvBindByName(column = "name")
        private String name;

        @DBField(name = "age")
        @CsvBindByName(column = "age")
        private int age;

        @DBField(name = "price")
        @CsvBindByName(column = "price")
        private float price;

        @CsvBindByName(column = "id")
        private UUID uuid;

        @DBField(name = "date")
        @CsvDate(value = "yyyy-MM-dd")
        @CsvBindByName(column = "date")
        private LocalDate date;
    }

    @DBClass
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Car implements Serializable {
        @CsvBindByName(column = "model")
        @DBField(name = "model")
        private String model;

        @CsvBindByName(column = "year")
        @DBField(name = "year")
        private int year;

        @CsvBindByName(column = "price")
        @DBField(name = "price")
        private float price;

        @CsvBindByName(column = "id")
        @DBField(name = "id")
        private UUID uuid;

        @CsvBindByName(column = "extraFeatures")
        @DBField(name = "extraFeatures")
        private boolean extraFeatures;

    }
}
