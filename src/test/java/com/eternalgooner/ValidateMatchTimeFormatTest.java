package com.eternalgooner;

import com.eternalgooner.validator.ValidateMatchTimeFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class ValidateMatchTimeFormatTest {

    private static final String VALID_MATCH_TIME = "[H1] 0:15.025";
    private static final String INVALID_MATCH_TIME = "[H3] 0:p5.025";

    @Test
    public void validateMatchPeriodValidTest(){
        boolean isValidMatchPeriod = ValidateMatchTimeFormat.validateMatchTime(VALID_MATCH_TIME);
        assertEquals(true, isValidMatchPeriod);
    }

    @Test
    public void validateMatchPeriodInvalidTest(){
        boolean isValidMatchPeriod = ValidateMatchTimeFormat.validateMatchTime(INVALID_MATCH_TIME);
        assertEquals(false, isValidMatchPeriod);
    }
}
