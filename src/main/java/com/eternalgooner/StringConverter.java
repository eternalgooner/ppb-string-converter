package com.eternalgooner;

import com.eternalgooner.app.StringConverterApp;
import com.eternalgooner.factory.MatchPeriodFactory;
import com.eternalgooner.matchperiodcalculations.MatchPeriodCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StringConverter {

    private final String matchPeriod;
    private final String matchTime;
    private final String inputLine;
    private String outputLine = "needs formatting";
    private static final String SPACE = " ";
    private static final Logger LOGGER = LogManager.getLogger(StringConverterApp.class.getName());
    private MatchPeriodCalculation matchPeriodToProcess;

    public StringConverter(String inputLine) {
        this.inputLine = inputLine;
        matchPeriod = inputLine.split(SPACE)[0];
        matchTime = inputLine.split(SPACE)[1];
    }

    public String getOutputFormat() {
        LOGGER.debug("now converting input line with match period: {}", matchPeriod);
        outputLine = getOutputFormatFromInput(matchPeriod);
        return outputLine;
    }

    private String getOutputFormatFromInput(String matchPeriod) {
        MatchPeriodCalculation matchPeriod1 = MatchPeriodFactory //TODO rename
                .getMatchPeriod(matchPeriod)
                .orElseThrow(() -> new IllegalArgumentException("Invalid match period: " + matchPeriod));
        return matchPeriod1.calculateOutputMatchTime(matchTime);
    }
}
