package org.example.filetypes;

import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import org.example.fileData.FileData;
import java.io.*;
import java.util.List;

public class CsvFile extends FileData {
    @Override
    public void saveToFile(List list) throws Exception {
        Writer writer = new FileWriter("C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".csv");
        HeaderColumnNameMappingStrategy<Object> strategy = new HeaderColumnNameMappingStrategyBuilder<>().build();
        strategy.setType(list.get(0).getClass());
        writer.write(convertToCsv(list, strategy));
        writer.close();
        System.out.println("Succesfully saved file to csv");
    }

    @Override
    public void readFromFile(List list) throws FileNotFoundException {
        String filePath = "C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".csv";
        File file = new File(filePath);
        if (file.exists()) {
            HeaderColumnNameMappingStrategy<Object> strategy = new HeaderColumnNameMappingStrategyBuilder<>().build();
            strategy.setType((list.get(0).getClass()));
            List<Object> beans = new CsvToBeanBuilder<>(new FileReader(filePath))
                    .withType((list.get(0).getClass()))
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
            System.out.println(beans);
        } else System.out.println("File does not exist");

    }

    public static <T> String convertToCsv(List<T> entitiesList, MappingStrategy<T> mappingStrategy) throws Exception {
        try (Writer writer = new StringWriter()) {
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            beanToCsv.write(entitiesList);
            return writer.toString();
        }
    }
}
