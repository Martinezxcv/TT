package org.example.filetypes;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.HeaderColumnNameMappingStrategyBuilder;
import com.opencsv.bean.MappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import lombok.Getter;
import org.example.interfaces.FiletypeStrategy;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
@Getter
public class CsvFileManager implements FiletypeStrategy {

    @Override
    public void saveToFile(List list, String path) throws Exception {
        try(Writer writer = new FileWriter(path)){
            Class listClass = list.get(0).getClass();
            HeaderColumnNameMappingStrategy<Object> strategy = new HeaderColumnNameMappingStrategyBuilder<>().build();
            strategy.setType(listClass);
            writer.write(convertToCsv(list, strategy));
            writer.close();
            System.out.println("Succesfully saved file to csv");
        }
    }

    @Override
    public void readFromFile(List list, String path) throws FileNotFoundException {
        File file = new File(path);
        if (file.exists()) {
            HeaderColumnNameMappingStrategy<Object> strategy = new HeaderColumnNameMappingStrategyBuilder<>().build();
            Class listClass = list.get(0).getClass();
            strategy.setType(listClass);
            List<Object> beans = new CsvToBeanBuilder<>(new FileReader(path))
                    .withType(listClass)
                    .withMappingStrategy(strategy)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build()
                    .parse();
            System.out.println(beans);
        } else System.out.println("File does not exist");
    }

    @Override
    public String getFileExtension() {
        return ".csv";
    }

    private static <T> String convertToCsv(List<T> entitiesList, MappingStrategy<T> mappingStrategy) throws Exception {
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
