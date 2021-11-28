package com.kst.namesorter.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {

    /**
     * Load all lines of file content into ArrayList
     * @param   fileName is the path of file
     * @return  the ArrayList of file
     * @throws  IOException if there's an error during read file
     */
    public ArrayList<String> loadFileContent(String fileName) throws IOException {
        ArrayList<String> lineOfFile = new ArrayList<>();
        Files.lines(Paths.get(fileName)).forEach(lineOfFile::add);
        return lineOfFile;
    }

    /**
     * Write all arraylist of string to file
     * @param   lines is list of string which need to write to file
     * @param   outputFilename is the path of output file
     * @throws  IOException if there's an error during write to file
     */
    public void writeToFile(ArrayList<String> lines, String outputFilename) throws IOException {
        FileWriter writer = new FileWriter(outputFilename);
        for (String str : lines) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

}
