package org.example.filetypes;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.example.annotations.DBField;
import org.example.fileData.FileData;
import org.example.fileData.LocalDateTypeAdapter;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class JsonFile extends FileData {

    @Override
    public void saveToFile(List list) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .addSerializationExclusionStrategy(strategy)
                .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
        Writer writer = new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".json");
        writer.write(gson.toJson(list));
        writer.close();
        System.out.println("Succesfully saved file to json");
    }

    @Override
    public void readFromFile(List list) throws FileNotFoundException {
        String filePath = "C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".json";
        File file = new File(filePath);
        if (file.exists()) {
            final Type REVIEW_TYPE = new TypeToken<List<Object>>() {
            }.getType();
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            JsonReader reader = new JsonReader(new FileReader(filePath));
            List<Object> jsonList = gson.fromJson(reader, REVIEW_TYPE);
            System.out.println(jsonList);
        } else System.out.println("File does not exist");
    }

    private final ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return field.getAnnotation(DBField.class)==null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    };
}
