package com.eternalgooner;

import com.eternalgooner.validator.ValidateMatchPeriodFormat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class ValidateMatchPeriodFormatTest {

    private static final String VALID_MATCH_PERIOD = "[H1] 0:15.025";
    private static final String INVALID_MATCH_PERIOD = "[H3] 0:15.025";

    @Test
    public void validateMatchPeriodValidTest(){
        ValidateMatchPeriodFormat.getMatchDataSections(VALID_MATCH_PERIOD);
        boolean isValidMatchPeriod = ValidateMatchPeriodFormat.validateMatchPeriod();
        assertEquals(true, isValidMatchPeriod);
    }

    @Test
    public void validateMatchPeriodInvalidTest(){
        ValidateMatchPeriodFormat.getMatchDataSections(INVALID_MATCH_PERIOD);
        boolean isInvalidMatchPeriod = ValidateMatchPeriodFormat.validateMatchPeriod();
        assertEquals(false, isInvalidMatchPeriod);
    }
}
