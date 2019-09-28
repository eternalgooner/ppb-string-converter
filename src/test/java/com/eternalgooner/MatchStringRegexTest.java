package com.eternalgooner;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/
public class MatchStringRegexTest {

    //valid times
    private final String VALID_PRE_MATCH_TIME = "0:00.000";
    private final String VALID_FIRST_HALF_UNDER_10_MINS = "0:15.025";
    private final String VALID_FIRST_HALF_OVER_10_MINS = "45:00.001";
    private final String VALID_SECOND_HALF = "90:00.908";

    //invalid times
    private final String INVALID_TIME_TOO_FEW_MINS = ":00.000";
    private final String INVALID_TIME_TOO_MANY_MINS = "1234:00.000";
    private final String INVALID_TIME_TOO_MANY_SECONDS = "0:151.025";
    private final String INVALID_TIME_TOO_FEW_SECONDS = "0:1.025";
    private final String INVALID_TIME_SEVENTY_SECONDS = "0:70.025";
    private final String INVALID_TIME_TOO_MANY_MILLISECONDS = "0:11.0287";
    private final String INVALID_TIME_LETTER_PRESENT = "4t:00.001";
    private final String INVALID_TIME_NEGATIVE_NUMBER = "-90:00.908";

    private final Pattern expectedMatchTimePattern = Pattern.compile("^(\\d?\\d:[0-5]\\d*\\d.\\d{3})");

    @Test
    public void validPreMatchTime(){
        final Matcher matcher = expectedMatchTimePattern.matcher(VALID_PRE_MATCH_TIME);
        assertEquals(true, matcher.matches());
    }

    @Test
    public void validFirstHalfTime(){
        final Matcher matcher = expectedMatchTimePattern.matcher(VALID_FIRST_HALF_OVER_10_MINS);
        assertEquals(true, matcher.matches());
    }

    @Test
    public void invalidTooFewMins(){
        final Matcher matcher = expectedMatchTimePattern.matcher(INVALID_TIME_TOO_FEW_MINS);
        assertEquals(false, matcher.matches());
    }

    @Test
    public void invalidTooManyMins(){
        final Matcher matcher = expectedMatchTimePattern.matcher(INVALID_TIME_TOO_MANY_MINS);
        assertEquals(false, matcher.matches());
    }

    @Test
    public void invalidSeventySeconds(){
        final Matcher matcher = expectedMatchTimePattern.matcher(INVALID_TIME_SEVENTY_SECONDS);
        assertEquals(false, matcher.matches());
    }

    @Test
    public void invalidLetterPresent(){
        final Matcher matcher = expectedMatchTimePattern.matcher(INVALID_TIME_LETTER_PRESENT);
        assertEquals(false, matcher.matches());
    }

    @Test
    public void invalidNegativeTime(){
        final Matcher matcher = expectedMatchTimePattern.matcher(INVALID_TIME_NEGATIVE_NUMBER);
        assertEquals(false, matcher.matches());
    }
}
