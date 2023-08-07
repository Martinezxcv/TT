package org.example.filetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.fileData.DBFieldModule;
import org.example.fileData.DogList;
import org.example.fileData.FileData;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlFile extends FileData {

    @Override
    public void saveToFile(List list) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        File file = new File("C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".yaml");
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new DBFieldModule());
        objectMapper.writeValue(file, list);
        System.out.println("Succesfully saved file to yaml");
    }

    @Override
    public void readFromFile(List list) throws IOException {
        File file = new File("C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".yaml");
        if (file.exists()) {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.registerModule(new JavaTimeModule());
            List<Object> objects = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, list.get(0).getClass()));
            System.out.println(objects);
        } else System.out.println("File does not exist");
    }
}
