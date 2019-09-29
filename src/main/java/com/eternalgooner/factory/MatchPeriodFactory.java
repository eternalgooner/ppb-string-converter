package com.eternalgooner.factory;

import com.eternalgooner.enums.InputMatchPeriod;
import com.eternalgooner.matchperiodcalculations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/

public class MatchPeriodFactory {

    private static final Logger LOGGER = LogManager.getLogger(MatchPeriodFactory.class.getName());
    private static Map<String, MatchPeriodCalculation> matchPeriodMap = new HashMap<>();

    static {
        matchPeriodMap.put(InputMatchPeriod.PM.getMatchPeriod(), new PreMatchPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.H1.getMatchPeriod(), new FirstHalfPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.HT.getMatchPeriod(), new HalfTimePeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.H2.getMatchPeriod(), new SecondHalfPeriodCalculation());
        matchPeriodMap.put(InputMatchPeriod.FT.getMatchPeriod(), new FullTimePeriodCalculation());
    }

    private MatchPeriodFactory() {
        throw new IllegalStateException("Factory class");
    }

    public static Optional<MatchPeriodCalculation> getMatchPeriod(String matchPeriod) {
        LOGGER.debug("returning {} match period from factory", matchPeriod);
        return Optional.ofNullable(matchPeriodMap.get(matchPeriod));
    }
}
