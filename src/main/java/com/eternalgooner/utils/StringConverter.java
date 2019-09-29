package com.eternalgooner.utils;

import com.eternalgooner.factory.MatchPeriodFactory;
import com.eternalgooner.matchperiodcalculations.MatchPeriodCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class StringConverter {

    private final String matchPeriod;
    private final String matchTime;
    private static final String SPACE = " ";
    private static final Logger LOGGER = LogManager.getLogger(StringConverter.class.getName());

    public StringConverter(String inputLine) {
        matchPeriod = inputLine.split(SPACE)[0];
        matchTime = inputLine.split(SPACE)[1];
    }

    public String getOutputFormat() {
        LOGGER.debug("now converting input line with match period: {}", matchPeriod);
        Optional<MatchPeriodCalculation> matchPeriodToProcess = MatchPeriodFactory.getMatchPeriod(matchPeriod);
        if(matchPeriodToProcess.isPresent()){
            return matchPeriodToProcess
                    .get()
                    .calculateOutputMatchTime(matchTime);
        }
        return "Problem getting output format, check the logs";
    }
}
