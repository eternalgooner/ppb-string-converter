package com.eternalgooner;

import com.eternalgooner.app.StringConverterApp;
import org.junit.jupiter.api.Test;

/**
 * @author David Mackessy
 * @date 30/09/2019
 **/

public class StringConverterAppTest {

    private static final String VALID_FILE = "src/test/resources/isValidFile.txt";
    private static final String INVALID_FILE = "src/test/resources/invalidFile.txt";

    @Test
    public void validInputFileTest(){
       String[] commandLineArgs = new String[1];
       commandLineArgs[0] = VALID_FILE;
        StringConverterApp.main(commandLineArgs);
    }

    @Test
    public void noArgsTest(){
        String[] commandLineArgs = new String[0];
        StringConverterApp.main(commandLineArgs);
    }

    @Test
    public void invalidInputFileTest(){
        String[] commandLineArgs = new String[1];
        commandLineArgs[0] = INVALID_FILE;
        StringConverterApp.main(commandLineArgs);
    }
}
