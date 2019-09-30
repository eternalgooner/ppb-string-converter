package com.eternalgooner;

import com.eternalgooner.utils.StringConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author David Mackessy
 * @date 30/09/2019
 **/

public class StringConverterTest {

    private static final String VALID_INPUT_LINE_PRE_MATCH = "[PM] 0:00.000";
    private static final String VALID_INPUT_LINE_FIRST_HALF = "[H1] 23:00.001";
    private static final String VALID_INPUT_LINE_FIRST_HALF_ADDED_TIME = "[H1] 45:04.501";
    private static final String VALID_INPUT_LINE_HALF_TIME = "[HT] 45:00.000";
    private static final String VALID_INPUT_LINE_SECOND_HALF = "[H2] 45:00.001";
    private static final String VALID_INPUT_LINE_SECOND_HALF_ADDED_TIME = "[H2] 90:00.001";
    private static final String VALID_INPUT_LINE_SECOND_HALF_ADDED_TIME_PLUS_ROUNDED_SECOND = "[H2] 90:00.777";
    private static final String VALID_INPUT_LINE_FULL_TIME = "[FT] 90:00.000";
    private static final String INVALID_INPUT_LINE_MATCH_PERIOD = "[H3] 45:00.001";
    private static final String INVALID_INPUT_LINE_MATCH_TIME = "[H1] 45:00";

    @Test
    public void validStringConverterTestPreMatch(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_PRE_MATCH);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("00:00 - PRE_MATCH", outputFormat);
    }

    @Test
    public void validStringConverterTestFirstHalf(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_FIRST_HALF);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("23:00 - FIRST_HALF", outputFormat);
    }

    @Test
    public void validStringConverterTestFirstHalfAddedTime(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_FIRST_HALF_ADDED_TIME);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("45:00 +00:05 - FIRST_HALF", outputFormat);
    }

    @Test
    public void validStringConverterTestHalfTime(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_HALF_TIME);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("45:00 - HALF_TIME", outputFormat);
    }

    @Test
    public void validStringConverterTestSecondHalf(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_SECOND_HALF);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("45:00 - SECOND_HALF", outputFormat);
    }

    @Test
    public void validStringConverterTestSecondHalfAddedTime(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_SECOND_HALF_ADDED_TIME);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("90:00 +00:00 - SECOND_HALF", outputFormat);
    }

    @Test
    public void validStringConverterTestSecondHalfAddedTimePlusRoudedSecond(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_SECOND_HALF_ADDED_TIME_PLUS_ROUNDED_SECOND);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("90:00 +00:01 - SECOND_HALF", outputFormat);
    }

    @Test
    public void validStringConverterTestFullTime(){
        StringConverter stringConverter = new StringConverter(VALID_INPUT_LINE_FULL_TIME);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("90:00 - FULL_TIME", outputFormat);
    }

    @Test
    public void invalidStringConverterTestMatchPeriod(){
        StringConverter stringConverter = new StringConverter(INVALID_INPUT_LINE_MATCH_PERIOD);
        String outputFormat = stringConverter.getOutputFormat();
        assertEquals("Problem getting output format, check the logs", outputFormat);
    }

    @Test
    public void invalidStringConverterTestMatchTime(){
        StringConverter stringConverter = new StringConverter(INVALID_INPUT_LINE_MATCH_TIME);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stringConverter.getOutputFormat();
        });
    }
}
