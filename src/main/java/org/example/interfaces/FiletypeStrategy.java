package org.example.interfaces;


import java.io.IOException;
import java.util.List;

public interface FiletypeStrategy {
 void saveToFile(List list) throws Exception;
 void readFromFile(List list) throws IOException;

}
