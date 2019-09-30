package com.eternalgooner;

import com.eternalgooner.utils.MatchTimeUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class MatchTimeUtilsTest {

    private static final String MS_GREATER_THAN_500 = "12:33.678";
    private static final String MS_EQUAL_TO_500 = "2:33.500";
    private static final String MS_LESS_THAN_500 = "44:33.499";

    @Test
    public void millisecondsGreaterThan500Test(){
        boolean msGreaterThan500 = MatchTimeUtils.millisecondsGreaterThanOrEqualTo500(MS_GREATER_THAN_500);
        assertEquals(true, msGreaterThan500);
    }

    @Test
    public void millisecondsEqualTo500Test(){
        boolean msGreaterThan500 = MatchTimeUtils.millisecondsGreaterThanOrEqualTo500(MS_EQUAL_TO_500);
        assertEquals(true, msGreaterThan500);
    }

    @Test
    public void millisecondsLessThan500Test(){
        boolean msGreaterThan500 = MatchTimeUtils.millisecondsGreaterThanOrEqualTo500(MS_LESS_THAN_500);
        assertEquals(false, msGreaterThan500);
    }

    @Test
    public void correctMatchMinutesTest(){
        int _44 = MatchTimeUtils.getMatchMinutesFromMatchTime(MS_LESS_THAN_500);
        assertEquals(44, _44);
    }

    @Test
    public void correctMatchSecondsTest(){
        int _33 = MatchTimeUtils.getMatchSecondsFromMatchTime(MS_LESS_THAN_500);
        assertEquals(33, _33);
    }

    @Test
    public void correctMatchMillisecondsTest(){
        int _499 = MatchTimeUtils.getMatchMillisecondsFromMatchTime(MS_LESS_THAN_500);
        assertEquals(499, _499);
    }


}
