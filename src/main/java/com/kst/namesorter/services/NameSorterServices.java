package com.kst.namesorter.services;

import com.kst.namesorter.utils.FileUtils;
import com.kst.namesorter.utils.NameUtils;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Service for sorting last name
 */
public class NameSorterServices {
    private final FileUtils fileUtils;
    private final NameUtils nameUtils;

    public NameSorterServices(FileUtils fileUtils, NameUtils nameUtils) {
        this.fileUtils = fileUtils;
        this.nameUtils = nameUtils;
    }

    /**
     * Sorting lastname from file
     * @param   inputUnsortedNameFilepath is the path of file which contains given unsorted full name
     * @param   outputSortedNameFilePath is the target of file which contain the result of sorted fullname
     * @return  the sorted list of name, and null if got exception
     */
    public ArrayList<String> sortLastNameService(String inputUnsortedNameFilepath, String outputSortedNameFilePath){
        ArrayList<String> result = null;
        try {
            //load list all fullname from unsorted file
            ArrayList<String> unsortedName = fileUtils.loadFileContent(inputUnsortedNameFilepath);
            //sort list by lastname
            unsortedName.sort(Comparator.comparing(nameUtils::getLastName));
            result = unsortedName;
            //print the result
            result.forEach(System.out::println);
            //write result to sorted file
            fileUtils.writeToFile(result, outputSortedNameFilePath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
