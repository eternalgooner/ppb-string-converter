package com.eternalgooner.factory;

import com.eternalgooner.enums.InputMatchPeriod;
import com.eternalgooner.matchperiodcalculations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/

public class MatchPeriodFactory {

    private static Map<String, MatchPeriodCalculation> matchPeriodMap = new HashMap<>();

    static {
        matchPeriodMap.put(InputMatchPeriod.PM.getMatchPeriod(), new PreMatchPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.H1.getMatchPeriod(), new FirstHalfPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.HT.getMatchPeriod(), new HalfTimePeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.H2.getMatchPeriod(), new SecondHalfPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.FT.getMatchPeriod(), new FullTimePeriodCalculation());
    }

    public static Optional<MatchPeriodCalculation> getMatchPeriod(String matchPeriod) {
        return Optional.ofNullable(matchPeriodMap.get(matchPeriod));
    }
}
