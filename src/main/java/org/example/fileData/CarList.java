package org.example.fileData;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CarList {
    DateFormatImpl dateFormat = new DateFormatImpl();
    List<FileData.Car> carList = List.of(
            new FileData.Car("Toyota", 1998, 19754.7f, UUID.randomUUID(), false),
            new FileData.Car("Opel", 2016, 24871.52f, UUID.randomUUID(), false),
            new FileData.Car("Ford", 2020, 47865.99f, UUID.randomUUID(), true));
}

