package com.eternalgooner.matchperiodcalculations;

import com.eternalgooner.app.StringConverterApp;
import com.eternalgooner.utils.MatchTimeUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class FirstHalfPeriodCalculation implements MatchPeriodCalculation {

    private static final String OUTPUT_MATCH_TIME = "00:00 – FIRST_HALF";

    private boolean addExtraMinuteFromMsRounding;
    private static final Logger LOGGER = LogManager.getLogger(FirstHalfPeriodCalculation.class.getName());

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        addExtraMinuteFromMsRounding = MatchTimeUtils.roundMilliseconds(matchTime);
        return OUTPUT_MATCH_TIME;
    }

}
