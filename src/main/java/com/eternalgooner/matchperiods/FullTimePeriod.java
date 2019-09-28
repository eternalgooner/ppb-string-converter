package com.eternalgooner.matchperiods;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class FullTimePeriod implements MatchPeriod {

    private static final String OUTPUT_MATCH_TIME = "00:00 – FULL_TIME";

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        return OUTPUT_MATCH_TIME;
    }
}
