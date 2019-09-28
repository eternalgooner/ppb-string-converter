package com.eternalgooner.utils;

import com.eternalgooner.matchperiodcalculations.FirstHalfPeriodCalculation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/

public class MatchTimeUtils {

    private static final String DOT = "\\.";
    private static final Logger LOGGER = LogManager.getLogger(MatchTimeUtils.class.getName());

    public static boolean roundMilliseconds(String matchTime) {
        LOGGER.debug("rounding milliseconds from match time: {}", matchTime);

        int milliseconds = Integer.parseInt(matchTime.split(DOT)[1]);
        LOGGER.debug("milliseconds from match time: {}", milliseconds);
        if(milliseconds > 500){
            LOGGER.debug("milliseconds > 500 so return true");
            return true;
        }
        LOGGER.debug("milliseconds < 500 so return false");
        return false;
    }
}
