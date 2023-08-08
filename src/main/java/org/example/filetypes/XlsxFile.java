package org.example.filetypes;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.annotations.DBField;
import org.example.fileData.FileData;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;

public class XlsxFile extends FileData {

    @Override
    public void saveToFile(List list) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(list.get(0).getClass().getSimpleName());
        Set<Integer> keyset = getData("headers",list).keySet();
        Row row = sheet.createRow(0);

        for (Integer key : keyset) {
            Object[] objArr = getData("headers",list).get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue((String) obj);
            }
        }
        keyset = getData("data",list).keySet();
        int rownum = 1;

        for (Integer key : keyset) {
            row = sheet.createRow(rownum++);
            Object[] objArr = getData("data",list).get(key);
            int cellnum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
                else if (obj instanceof Float)
                    cell.setCellValue((Float) obj);
                else if (obj instanceof LocalDate)
                    cell.setCellValue((LocalDate) obj);
                else if (obj instanceof UUID)
                    cell.setCellValue(String.valueOf(obj));
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj) ;
            }
        }

        try {
            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".xlsx");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Succesfully saved file to xlsx");
    }

    @Override
    public void readFromFile(List list) throws IOException {
        String filePath = "C:\\Users\\mmazurek\\Desktop\\pliki\\"+list.get(0).getClass().getSimpleName()+".xlsx";
        File checkFile = new File(filePath);
        if (checkFile.exists()) {
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Map<Integer, List<String>> data = new HashMap<>();
            Sheet sheet = workbook.getSheetAt(0);
            int i = 0;

            for (Row row : sheet) {
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> data.get(i).add(cell.getRichStringCellValue().getString());
                        case NUMERIC -> {
                            if (DateUtil.isCellDateFormatted(cell)) {
                                data.get(i).add(String.valueOf(cell.getDateCellValue()));
                            } else {
                                data.get(i).add(String.valueOf(cell.getNumericCellValue()));
                            }
                        }
                        case BOOLEAN -> data.get(i).add(String.valueOf(cell.getBooleanCellValue()));
                        case FORMULA -> data.get(i).add(cell.getCellFormula());
                        default -> data.get(i).add(" ");
                    }
                }
                i++;
            }
            data.forEach((key, value) -> System.out.println(key + " => " + value));
        } else System.out.println("File does not exist");
    }

    public Map<Integer, Object[]> getData(String type, List list) {
        Map<Integer, Object> data = new TreeMap<>();
        final int[] i = {0};
        list.forEach(obj -> {
            i[0]++;
            data.put(i[0], obj);
        });
        Map<Integer, Object[]> finalData = new TreeMap<>();
        data.forEach((uuid, value) -> {
            List<Object> fieldValue = new ArrayList<>();
                for (Field field : value.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(DBField.class)) {
                        try {
                            field.setAccessible(true);
                            if (type.equalsIgnoreCase("data")) {
                                fieldValue.add(field.get(value));
                                finalData.put(uuid, fieldValue.toArray());
                            } else if (type.equalsIgnoreCase("headers")) {
                                fieldValue.add(field.getName());
                                finalData.put(uuid, fieldValue.toArray());
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        });
        return finalData;
    }
}
