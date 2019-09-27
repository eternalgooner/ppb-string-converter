package com.eternalgooner.matchperiods;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class PreMatchPeriod implements MatchPeriod {

    @Override
    public String calculateMatchTime() {
        return "PreMatchPeriod";
    }
}
