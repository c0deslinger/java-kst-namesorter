package com.kst.namesorter.utils;

public class NameUtils {
    /**
     * Get lastname
     * @param   fullName is given of full name
     * @return  the last name
     */
    public String getLastName(String fullName){
        return fullName.substring(fullName.lastIndexOf(" ")+1);
    }
}
