package com.eternalgooner;

import com.eternalgooner.utils.CustomFileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class CustomFileUtilsTest {

    @Test
    public void validFileTest(){
        boolean isValidFile = CustomFileUtils.checkIfValidFile("src/test/resources/isValidFile.txt");
        assertEquals(true, isValidFile);
    }

    @Test
    public void invalidFileTest(){
        boolean isInvalidFile = CustomFileUtils.checkIfValidFile("src/test/resources/isInvalidFile.txt");
        assertEquals(false, isInvalidFile);
    }
}
