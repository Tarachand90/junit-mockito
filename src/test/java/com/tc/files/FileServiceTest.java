package com.tc.files;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileServiceTest {
    private FileService fileService;

    @BeforeEach
    void setUp() {
        fileService = new FileService();
    }

    @Test
    void testReadFileExceptionHandled() {
        String result = fileService.readFile("non-existing-file.txt");
        assertEquals("Error: Unable to read file", result,
                "When IOException occurs, it should return fallback message");
    }
}
