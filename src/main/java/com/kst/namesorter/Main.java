package com.kst.namesorter;


import com.kst.namesorter.services.NameSorterServices;
import com.kst.namesorter.utils.FileUtils;
import com.kst.namesorter.utils.NameUtils;

public class Main {
    public static void main(String[] args) {
        FileUtils fileUtils = new FileUtils();
        NameUtils nameUtils = new NameUtils();
        String unsortedNamesFilePath = "./unsorted-names-list.txt";
        String sortedNamesFilePath = "./sorted-names-list.txt";
        //if unsorted & sorted file path is defined inside arguments, then use from arguments instead
        if(args.length == 2){
            unsortedNamesFilePath = args[0];
            sortedNamesFilePath = args[1];
        }
        NameSorterServices nameSorterServices = new NameSorterServices(fileUtils, nameUtils);
        nameSorterServices.sortLastNameService(unsortedNamesFilePath, sortedNamesFilePath);
    }
}
