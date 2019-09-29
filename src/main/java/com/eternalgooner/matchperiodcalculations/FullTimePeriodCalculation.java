package com.eternalgooner.matchperiodcalculations;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class FullTimePeriodCalculation implements MatchPeriodCalculation {

    private static final String OUTPUT_MATCH_TIME = "90:00 - FULL_TIME";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
