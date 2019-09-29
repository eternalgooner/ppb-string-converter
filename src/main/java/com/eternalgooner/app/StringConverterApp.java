package com.eternalgooner.app;

import com.eternalgooner.utils.StringConverter;
import com.eternalgooner.utils.CustomFileUtils;
import com.eternalgooner.validator.ValidateMatchPeriodFormat;
import com.eternalgooner.validator.ValidateMatchTimeFormat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author David Mackessy
 * @date 26/09/2019
 **/

public class StringConverterApp {

    private static final Logger LOGGER = LogManager.getLogger(StringConverterApp.class.getName());
    private static final int EXPECTED_MATCH_DATA_SECTIONS = 2;
    private static final String INVALID = "INVALID";

    public static void main (String[] commandLineArgs){
        if(commandLineArgs.length != 0){
            LOGGER.debug("commandLineArgs not null, continue with app flow");
            new StringConverterApp().continueWithAppFlow(commandLineArgs);
        }else{
            LOGGER.info("no arguments passed through the command line, please check the documentation and try again");
        }
    }

    private void continueWithAppFlow(String[] commandLineArgs) {
        String fileName = commandLineArgs[0];
        boolean isValidFile = CustomFileUtils.checkIfValidFile(fileName);
        if(isValidFile){
            LOGGER.debug("valid file has been identified, proceeding to next step");
            streamMatchStringDataAndProcess(fileName);
        }
    }

    private void streamMatchStringDataAndProcess(String matchDataFile) {
        if(matchDataFile != null){
            LOGGER.debug("try to stream each line in the file");
            try {
                Files.lines(Paths.get(matchDataFile))
                        .forEach(this::validateMatchDataSections);
            } catch (IOException e) {
                LOGGER.error("IOException caught: {}", e);
            }
        }
    }

    private void validateMatchDataSections(String inputLine) {
        LOGGER.debug(String.format("%n"));
        LOGGER.debug("***********************************************************************");
        LOGGER.debug("**** validating line: {} ****", inputLine);
        int matchDataSections = ValidateMatchPeriodFormat.getMatchDataSections(inputLine);

        if(matchDataSections == EXPECTED_MATCH_DATA_SECTIONS){
            LOGGER.debug("matchDataSections == 2");
            validateMatchPeriod(inputLine);
        }else{
            LOGGER.info(INVALID);
        }
    }

    private void validateMatchPeriod(String inputLine) {
        boolean isValidMatchPeriod = ValidateMatchPeriodFormat.validateMatchPeriod();
        LOGGER.debug("isValidMatchPeriod: {}", isValidMatchPeriod);
        if(isValidMatchPeriod){
            validateMatchTime(inputLine);
        }else{
            LOGGER.info(INVALID);
        }
    }

    private void validateMatchTime(String line) {
        boolean isValidMatchTime = ValidateMatchTimeFormat.validateMatchTime(line);
        if(isValidMatchTime){
            LOGGER.debug("isValidMatchTime: {}, convert string to expected output format", isValidMatchTime);
            convertInputStringToExpectedOutput(line);
        }else {
            LOGGER.debug("isValidMatchTime: {}, stop processing, ouput INVALID", isValidMatchTime);
            LOGGER.info(INVALID);
        }
    }

    private void convertInputStringToExpectedOutput(String line) {
        StringConverter stringConverter = new StringConverter(line);
        String outputFormat = stringConverter.getOutputFormat();
        LOGGER.info(outputFormat);
    }
}
