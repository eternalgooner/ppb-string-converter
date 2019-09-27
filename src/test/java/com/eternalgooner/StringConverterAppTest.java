package com.eternalgooner;

import com.eternalgooner.app.StringConverterApp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class StringConverterAppTest {

    @Test
    public void validFileTest(){

        StringConverterApp stringConverterApp = new StringConverterApp();
        assertEquals(true, true);
    }

    @Test
    public void invalidFileTest(){

        assertEquals(true, true);
    }
}
