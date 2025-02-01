package com.tc.files;

import com.tc.exceptions.FileProcessingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

    public String readFile(String filePath) {
        try {
            return readFromFile(filePath);
        } catch (FileProcessingException e) {
            return "Error: Unable to read file"; // Fallback response
        }
    }

    private String readFromFile(String filePath) throws FileProcessingException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        }catch (IOException e) {
            throw new FileProcessingException("File not found: "+filePath);
        }
    }
}
