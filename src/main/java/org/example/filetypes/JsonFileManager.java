package org.example.filetypes;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.annotations.IncludeInFile;
import org.example.fileData.LocalDateTypeAdapter;
import org.example.interfaces.FiletypeStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class JsonFileManager implements FiletypeStrategy {

    @Override
    public void saveToFile(List list, String path) throws IOException {
        try(Writer writer = new FileWriter(path)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .addSerializationExclusionStrategy(strategy)
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            writer.write(gson.toJson(list));
            writer.close();
            System.out.println("Succesfully saved file to json");
        }
    }

    @Override
    public void readFromFile(List list, String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            final Type REVIEW_TYPE = new TypeToken<List<Object>>() {
            }.getType();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            JsonReader reader = new JsonReader(new FileReader(path));
            List<Object> jsonList = gson.fromJson(reader, REVIEW_TYPE);
            System.out.println(jsonList);
        } else System.out.println("File does not exist");
    }

    @Override
    public String getFileExtension() {
        return ".json";
    }

    private final ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return field.getAnnotation(IncludeInFile.class) == null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    };
}
