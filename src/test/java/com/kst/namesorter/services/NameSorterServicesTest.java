package com.kst.namesorter.services;

import com.kst.namesorter.utils.FileUtils;
import com.kst.namesorter.utils.NameUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DisplayName("Test Name Sorter Service")
class NameSorterServicesTest {

    FileUtils fileUtils = new FileUtils();
    NameUtils nameUtils = new NameUtils();
    NameSorterServices nameSorterServices = new NameSorterServices(fileUtils, nameUtils);

    String unsortedFilePath = "unit-test-unsorted.txt";
    String sortedFilepath = "unit-test-sorted.txt";

    ArrayList<String> listOfUnsortedName = new ArrayList<>();

    @BeforeEach
    void setUp() throws IOException {
        //create dummy unsorted file
        listOfUnsortedName.add("David Beckham");
        listOfUnsortedName.add("Bryan Adams");
        listOfUnsortedName.add("Leonardo De Caprio");
        fileUtils.writeToFile(listOfUnsortedName, unsortedFilePath);
    }

    @AfterEach
    void tearDown() {
        //remove unused file
        try {
            if(new File(sortedFilepath).exists())
                Files.delete(Paths.get(sortedFilepath));
            if(new File(unsortedFilePath).exists())
                Files.delete(Paths.get(unsortedFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("when success sorting name (+)")
    public void positiveSortingName() throws IOException {
        //read result list
        ArrayList<String> result = nameSorterServices.sortLastNameService(unsortedFilePath, sortedFilepath);
        //check sorted result
        assertEquals(listOfUnsortedName.get(1), result.get(0));
        assertEquals(listOfUnsortedName.get(0), result.get(1));
        assertEquals(listOfUnsortedName.get(2), result.get(2));
        //check result of sorted file
        assertEquals(result, fileUtils.loadFileContent(sortedFilepath));
    }

    @Test
    @DisplayName("when list of unsorted file is empty (-)")
    public void negativeEmptyUnsortedFile() throws IOException {
        String emptyUnsortedFilePath = "unit-test-empty.txt";
        ArrayList<String> listOfUnsortedName = new ArrayList<>();
        fileUtils.writeToFile(listOfUnsortedName, emptyUnsortedFilePath);
        nameSorterServices = new NameSorterServices(fileUtils, nameUtils);
        //read result list
        ArrayList<String> result = nameSorterServices.sortLastNameService(emptyUnsortedFilePath, sortedFilepath);
        assertEquals(result, new ArrayList<>());
        Files.delete(Paths.get(emptyUnsortedFilePath));
    }

    @Test
    @DisplayName("when unsorted file not found (-)")
    public void negativeFileNotFound() {
        ArrayList<String> result = nameSorterServices.sortLastNameService("notfoundfile", sortedFilepath);
        assertNull(result);
    }
}