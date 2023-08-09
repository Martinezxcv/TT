package org.example.filetypes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.fileData.IncludeInFileModule;
import org.example.interfaces.FiletypeStrategy;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class YamlFileManager implements FiletypeStrategy {

    @Override
    public void saveToFile(List list, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        File file = new File(path);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new IncludeInFileModule());
        objectMapper.writeValue(file, list);
        System.out.println("Succesfully saved file to yaml");
    }

    @Override
    public void readFromFile(List list, String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            Class listClass = list.get(0).getClass();
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            objectMapper.registerModule(new JavaTimeModule());
            List<Object> objects = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class,listClass));
            System.out.println(objects);
        } else System.out.println("File does not exist");
    }

    @Override
    public String getFileExtension() {
        return ".yaml";
    }
}
