package com.eternalgooner.matchperiodcalculations;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class FirstHalfPeriodCalculation implements MatchPeriodCalculation {

    private static final String OUTPUT_MATCH_TIME = "00:00 – FIRST_HALF";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
