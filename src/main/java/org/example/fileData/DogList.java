package org.example.fileData;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class DogList {

    DateFormatImpl dateFormat = new DateFormatImpl();
    List<FileData.Dog> dogList = List.of(
            new FileData.Dog("Q", 3, 3456f, UUID.randomUUID(), dateFormat.dateFormat()),
            new FileData.Dog("W", 4, 3765f, UUID.randomUUID(), dateFormat.dateFormat()),
            new FileData.Dog("E", 5, 1459f, UUID.randomUUID(), dateFormat.dateFormat()));
}
