package com.eternalgooner.app;

import com.eternalgooner.utils.CustomFileUtils;
import com.eternalgooner.validator.ValidateMatchDataFormat;
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
        if(commandLineArgs != null){
            LOGGER.debug("commandLineArgs not null, continue with app flow");
            new StringConverterApp().continueWithAppFlow(commandLineArgs);
        }else{
            LOGGER.info("no arguments passed through the command line, please check the documentation and try again");
        }
    }

    private void continueWithAppFlow(String[] commandLineArgs) {
        //String fileName = commandLineArgs[0];//TODO revert
        String fileName = "C:\\dev\\PPB\\inputs Jr Java Dev coding assessment[9244].txt";
        boolean isValidFile = CustomFileUtils.checkIfValidFile(fileName);
        if(isValidFile){
            LOGGER.info("valid file has been identified, proceeding to next step");
            streamMatchStringDataAndProcess(fileName);
        }
    }

    private void streamMatchStringDataAndProcess(String matchDataFile) {
        if(matchDataFile != null){
            LOGGER.info("try to stream each line in the file");
            try {
                Files.lines(Paths.get(matchDataFile))
                        .forEach(line -> validateMatchDataSections(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void validateMatchDataSections(String line) {
        int matchDataSections = ValidateMatchDataFormat.getMatchDataSections(line);

        if(matchDataSections == EXPECTED_MATCH_DATA_SECTIONS){
            LOGGER.info("matchDataSections == 2");
            validateMatchPeriod(line);
        }else{
            LOGGER.info(INVALID);
        }

    }

    private void validateMatchPeriod(String line) {
        boolean isValidMatchPeriod = ValidateMatchDataFormat.validateMatchPeriod();
        LOGGER.info("isValidMatchPeriod: {}", isValidMatchPeriod);
    }
}
