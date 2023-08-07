package org.example.fileData;

import com.google.gson.annotations.Expose;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.annotations.IncludeInDTO;
import org.example.interfaces.FiletypeStrategy;
import org.example.annotations.DBClass;
import org.example.annotations.DBField;
import org.example.annotations.DateFormat;

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
        @CsvBindByName(column =  "name")
        @IncludeInDTO
        String name;
        @DBField(name = "age")
        @CsvBindByName(column =  "age")
        int age;
        @DBField(name = "price")
        @CsvBindByName(column =  "price")
        float price;
        //@DBField(name = "id")
        @CsvBindByName(column =  "id")
        UUID uuid;
        @DateFormat(dateFormat = "yyyy-MM-dd")
       // @DBField(name = "date")
        @CsvDate(value = "yyyy-MM-dd")
        @CsvBindByName(column =  "date")
        LocalDate date;
    }


    @DBClass
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Car implements Serializable {
        @CsvBindByName(column =  "model")
        @DBField(name = "model")
        String model;
        @CsvBindByName(column =  "year")
        @DBField(name = "year")
        int year;
        @CsvBindByName(column =  "price")
        @DBField(name = "price")
        float price;
        @CsvBindByName(column =  "id")
        @DBField(name = "id")
        UUID uuid;
        //@CsvBindByName(column = "extraFeatures")
        @DBField(name = "extraFeatures")
        private boolean extraFeatures;

    }
}
