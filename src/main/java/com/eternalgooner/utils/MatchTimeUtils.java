package com.eternalgooner.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 28/09/2019
 **/

public class MatchTimeUtils {

    private static final String DOT = "\\.";
    private static final Logger LOGGER = LogManager.getLogger(MatchTimeUtils.class.getName());

    private MatchTimeUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean millisecondsGreaterThanOrEqualTo500(String matchTime) {
        LOGGER.debug("rounding milliseconds from match time: {}", matchTime);

        int milliseconds = Integer.parseInt(matchTime.split(DOT)[1]);
        LOGGER.debug("milliseconds from match time: {}", milliseconds);
        if(milliseconds >= 500){
            LOGGER.debug("milliseconds >= 500 so round up");
            return true;
        }
        LOGGER.debug("milliseconds < 500 so don't round up");
        return false;
    }

    public static int getMatchMinutesFromMatchTime(String matchTime) {
        int matchMinutes = Integer.parseInt(matchTime.split(":")[0]);
        LOGGER.debug("match minutes: {}", matchMinutes);
        return matchMinutes;
    }

    public static int getMatchSecondsFromMatchTime(String matchTime) {
        int matchSeconds = Integer.parseInt(matchTime.split(":")[1].split("\\.")[0]);
        LOGGER.debug("match seconds: {}", matchSeconds);
        return matchSeconds;
    }

    public static int getMatchMillisecondsFromMatchTime(String matchTime) {
        int matchMilliseconds = Integer.parseInt(matchTime.split(":")[1].split("\\.")[1]);
        LOGGER.debug("match milliseconds: {}", matchMilliseconds);
        return matchMilliseconds;
    }
}
