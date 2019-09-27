package com.eternalgooner.validator;

import com.eternalgooner.app.StringConverterApp;
import com.eternalgooner.enums.InputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class ValidateMatchDataFormat {

    private static final String SPACE = " ";
    private static String[] matchDataSections;
    private static final Logger LOGGER = LogManager.getLogger(StringConverterApp.class.getName());

    public static int getMatchDataSections(String matchData){
        matchDataSections = matchData.split(SPACE);
        LOGGER.info("returning matchDataSections of size: {}", matchDataSections.length);
        return matchDataSections.length;
    }

    public static boolean validateMatchPeriod() {
        String matchPeriod = matchDataSections[0];
        List<InputMatchPeriod> inputMatchPeriodsWithoutBrackets = Arrays.asList(InputMatchPeriod.values());
        List<String> inputMatchPeriods = inputMatchPeriodsWithoutBrackets.stream()
                                                .map(entry -> entry.getMatchPeriod())
                                                .collect(Collectors.toList());
        LOGGER.info("checking if matchPeriod {} is present in predefined enum list {}", matchPeriod, inputMatchPeriods);
        return inputMatchPeriods.contains(matchPeriod);
    }
}
