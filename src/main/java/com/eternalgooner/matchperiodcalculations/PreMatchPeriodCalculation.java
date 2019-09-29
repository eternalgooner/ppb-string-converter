package com.eternalgooner.matchperiodcalculations;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class PreMatchPeriodCalculation implements MatchPeriodCalculation {

    private static final String OUTPUT_MATCH_TIME = "00:00 - PRE_MATCH";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
