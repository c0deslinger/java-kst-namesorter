package com.kst.namesorter.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test FileUtils")
public class FileUtilsTest {

    FileUtils fileUtils = new FileUtils();

    @Test
    @DisplayName("when success read and write file (+)")
    public void positiveWriteAndReadFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        String filename = "unit-test-readwrite.txt";
        lines.add("first line");
        lines.add("second line");
        //write list of lines to file
        fileUtils.writeToFile(lines, filename);
        //load all lines from file to list
        ArrayList<String> fileContent = fileUtils.loadFileContent(filename);
        //check is all lines same or not
        assertEquals(lines, fileContent);
        //remove file after unused
        Files.delete(Paths.get(filename));
    }

    @Test
    @DisplayName("when load file not found (-)")
    public void negativeFileNotFound() {
        assertThrows(IOException.class, () -> fileUtils.loadFileContent("notfoundfile.txt"));
    }
}
