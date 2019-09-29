package com.eternalgooner.matchperiodcalculations;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class HalfTimePeriodCalculation implements MatchPeriodCalculation {

    private static final String OUTPUT_MATCH_TIME = "45:00 – HALF_TIME";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
