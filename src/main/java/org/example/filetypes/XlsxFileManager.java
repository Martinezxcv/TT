package org.example.filetypes;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.annotations.IncludeInFile;
import org.example.interfaces.FiletypeStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;

public class XlsxFileManager implements FiletypeStrategy {

@Override
public void saveToFile(List list, String path) {
    XSSFWorkbook workbook = new XSSFWorkbook();
    Class<?> listClass = list.get(0).getClass();
    XSSFSheet sheet = workbook.createSheet(listClass.getSimpleName());

    createHeaderRow(sheet, list);
    fillDataRows(sheet, list);

    try (FileOutputStream outputStream = new FileOutputStream(path)) {
        workbook.write(outputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Successfully saved file to xlsx");
}

    private void createHeaderRow(XSSFSheet sheet, List<?> list) {
        Map<Integer, Object[]> headersData = extractData("headers", list);
        Set<Integer> headerKeys = headersData.keySet();
        Row headerRow = sheet.createRow(0);

        for (Integer key : headerKeys) {
            Object[] headerArray = headersData.get(key);
            int cellnum = 0;

            for (Object header : headerArray) {
                Cell cell = headerRow.createCell(cellnum++);
                cell.setCellValue((String) header);
            }
        }
    }

    private void fillDataRows(XSSFSheet sheet, List<?> list) {
        Map<Integer, Object[]> dataMap = extractData("data", list);
        Set<Integer> dataKeys = dataMap.keySet();
        int rownum = 1;

        for (Integer key : dataKeys) {
            Row dataRow = sheet.createRow(rownum++);
            Object[] dataObjectArray = dataMap.get(key);
            int cellnum = 0;

            for (Object data : dataObjectArray) {
                Cell cell = dataRow.createCell(cellnum++);
                setCellValue(cell, data);
            }
        }
    }

    private void setCellValue(Cell cell, Object value) {
        if (value instanceof String)
            cell.setCellValue((String) value);
        else if (value instanceof Integer)
            cell.setCellValue((Integer) value);
        else if (value instanceof Float)
            cell.setCellValue((Float) value);
        else if (value instanceof LocalDate)
            cell.setCellValue((LocalDate) value);
        else if (value instanceof UUID)
            cell.setCellValue(value.toString());
        else if (value instanceof Boolean)
            cell.setCellValue((Boolean) value);
    }

@Override
public void readFromFile(List list, String path) throws IOException {
    File checkFile = new File(path);
    if (checkFile.exists()) {
        FileInputStream file = new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(file);
        Map<Integer, List<String>> data = extractDataFromWorkbook(workbook);
        printData(data);
    } else {
        System.out.println("File does not exist");
    }
}

    private Map<Integer, List<String>> extractDataFromWorkbook(Workbook workbook) {
        Map<Integer, List<String>> data = new HashMap<>();
        Sheet sheet = workbook.getSheetAt(0);
        int index = 0;
        for (Row row : sheet) {
            data.put(index, new ArrayList<>());
            for (Cell cell : row) {
                String cellValue = extractCellValue(cell);
                data.get(index).add(cellValue);
            }
            index++;
        }
        return data;
    }

    private String extractCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return String.valueOf(cell.getDateCellValue());
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return " ";
        }
    }

    private void printData(Map<Integer, List<String>> data) {
        data.forEach((key, value) -> System.out.println(key + " => " + value));
    }

    @Override
    public String getFileExtension() {
        return ".xlsx";
    }

//    private Map<Integer, Object[]> getData(String type, List list) {
//        Map<Integer, Object> data = new TreeMap<>();
//        final int[] index = {0};
//        list.forEach(obj -> data.put(index[0]++, obj));
//        Map<Integer, Object[]> finalData = new TreeMap<>();
//        data.forEach((uuid, value) -> {
//            List<Object> fieldValue = new ArrayList<>();
//            for (Field field : value.getClass().getDeclaredFields()) {
//                if (field.isAnnotationPresent(IncludeInFile.class)) {
//                    try {
//                        field.setAccessible(true);
//                        if (type.equalsIgnoreCase("data")) {
//                            fieldValue.add(field.get(value));
//                            finalData.put(uuid, fieldValue.toArray());
//                        } else if (type.equalsIgnoreCase("headers")) {
//                            fieldValue.add(field.getName());
//                            finalData.put(uuid, fieldValue.toArray());
//                        }
//                    } catch (IllegalAccessException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//        return finalData;
//    }
public Map<Integer, Object[]> extractData(String type, List<?> dataList) {
    Map<Integer, Object[]> finalData = new TreeMap<>();
    Map<Integer, Object> data = prepareData(dataList);

    data.forEach((uuid, value) -> {
        List<Object> fieldValue = getFieldValues(value, type);
        finalData.put(uuid, fieldValue.toArray());
    });

    return finalData;
}

    private Map<Integer, Object> prepareData(List<?> dataList) {
        Map<Integer, Object> data = new TreeMap<>();
        final int[] index = {0};
        dataList.forEach(obj -> data.put(index[0]++, obj));
        return data;
    }

    private List<Object> getFieldValues(Object value, String type) {
        List<Object> fieldValue = new ArrayList<>();
        for (Field field : value.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(IncludeInFile.class)) {
                try {
                    field.setAccessible(true);
                    Object fieldValueToAdd = getFieldData(field, value, type);
                    fieldValue.add(fieldValueToAdd);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return fieldValue;
    }

    private Object getFieldData(Field field, Object value, String type) throws IllegalAccessException {
        if (type.equalsIgnoreCase("data")) {
            return field.get(value);
        } else if (type.equalsIgnoreCase("headers")) {
            return field.getName();
        }
        throw new IllegalArgumentException("Invalid data type: " + type);
    }
}
