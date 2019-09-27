package com.eternalgooner.enums;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public enum MatchPeriod {

    PM("[PM]"),
    H1("[H1]"),
    HT("[HT]"),
    H2("[H2]"),
    FT("[FT]");

    private String matchPeriod;

    public String getMatchPeriod(){
        return this.matchPeriod;
    }

    MatchPeriod(String matchPeriod) {
        this.matchPeriod = matchPeriod;
    }
}
