package com.eternalgooner.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class ValidateMatchTimeFormat {

    private static final Logger LOGGER = LogManager.getLogger(ValidateMatchTimeFormat.class.getName());
    private static final String SPACE = " ";
    private static final int MATCH_TIME = 1;

    private ValidateMatchTimeFormat() {
        throw new IllegalStateException("Validator class");
    }

    public static boolean validateMatchTime(String inputLine) {
        String matchTime = getMatchTimeFromMatchDataSections(inputLine);
        boolean isValidMatchTime = applyValidTimeRegex(matchTime);
        LOGGER.debug("regex applied, isValidMatchTime: {}", isValidMatchTime);
        return isValidMatchTime;
    }

    private static boolean applyValidTimeRegex(String matchTime) {
        final Pattern expectedMatchTimePattern = Pattern.compile("^(\\d?\\d:[0-5]\\d*\\d.\\d{3})");
        final Matcher matcher = expectedMatchTimePattern.matcher(matchTime);
        return matcher.matches();
    }

    private static String getMatchTimeFromMatchDataSections(String inputLine) {
        String[] matchDataSections = inputLine.split(SPACE);
        LOGGER.debug("returning matchTime: {}", matchDataSections[MATCH_TIME]);
        return matchDataSections[MATCH_TIME];
    }
}
