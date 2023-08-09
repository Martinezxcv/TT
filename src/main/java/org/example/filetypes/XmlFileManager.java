package org.example.filetypes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.fileData.IncludeInFileModule;
import org.example.fileData.LocalDateDeserializer;
import org.example.interfaces.FiletypeStrategy;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class XmlFileManager implements FiletypeStrategy {

    @Override
    public void saveToFile(List list, String path) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        xmlMapper.registerModule(new IncludeInFileModule());
        xmlMapper.writeValue(new File(path), list);
        System.out.println("Succesfully saved file to xml");
    }

    @Override
    public void readFromFile(List list, String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            SimpleModule module = new SimpleModule();
            XmlMapper xmlMapper = new XmlMapper();
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            xmlMapper.registerModule(module);
            List<Object> objects = xmlMapper.readValue(file, new TypeReference<>() {
            });
            System.out.println(objects);
        } else System.out.println("File does not exist");
    }

    @Override
    public String getFileExtension() {
        return ".xml";
    }
}
