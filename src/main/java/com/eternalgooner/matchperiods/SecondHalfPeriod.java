package com.eternalgooner.matchperiods;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class SecondHalfPeriod implements MatchPeriod {

    private static final String OUTPUT_MATCH_TIME = "00:00 – SECOND_HALF";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
