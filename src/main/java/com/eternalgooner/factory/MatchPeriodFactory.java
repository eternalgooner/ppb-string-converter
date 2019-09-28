package com.eternalgooner.factory;

import com.eternalgooner.enums.InputMatchPeriod;
import com.eternalgooner.matchperiods.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/

public class MatchPeriodFactory {

    private static Map<String, MatchPeriod> matchPeriodMap = new HashMap<>();

    static {
        matchPeriodMap.put(InputMatchPeriod.PM.getMatchPeriod(), new PreMatchPeriod());
        matchPeriodMap.put(InputMatchPeriod.H1.getMatchPeriod(), new FirstHalfPeriod());
        matchPeriodMap.put(InputMatchPeriod.HT.getMatchPeriod(), new HalfTimePeriod());
        matchPeriodMap.put(InputMatchPeriod.H2.getMatchPeriod(), new SecondHalfPeriod());
        matchPeriodMap.put(InputMatchPeriod.FT.getMatchPeriod(), new FullTimePeriod());
    }

    public static Optional<MatchPeriod> getMatchPeriod(String matchPeriod) {
        return Optional.ofNullable(matchPeriodMap.get(matchPeriod));
    }
}
