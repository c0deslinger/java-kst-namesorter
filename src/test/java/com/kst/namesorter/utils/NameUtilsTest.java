package com.kst.namesorter.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test NameUtils")
public class NameUtilsTest {
    NameUtils nameUtils = new NameUtils();

    @Test
    @DisplayName("when success get last name (+)")
    public void positiveGetLastName(){
        String lastName = nameUtils.getLastName("Yusuf Fachroni");
        assertEquals(lastName, "Fachroni");
    }

    @Test
    @DisplayName("when get last name is the fullname (+)")
    public void positiveLastnameIsFullname(){
        String lastName = nameUtils.getLastName("Yusuf");
        assertEquals(lastName, "Yusuf");
    }

    @Test
    @DisplayName("when the fullname is empty (-)")
    public void negativeEmptyFullname(){
        String lastName = nameUtils.getLastName("");
        assertEquals(lastName, "");
    }
}
