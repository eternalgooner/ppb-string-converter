package com.eternalgooner.app;

import com.eternalgooner.utils.MyFileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author David Mackessy
 * @date 26/09/2019
 **/

public class StringConverterApp {

    private static final Logger LOGGER = LogManager.getLogger(StringConverterApp.class.getName());
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
        boolean isValidFile = MyFileUtils.checkIfValidFile(fileName);
        if(isValidFile){
            LOGGER.info("valid file has been identified, proceeding to next step");
            streamMatchStringDataAndProcess(fileName);
        }
    }

    private void streamMatchStringDataAndProcess(String matchDataFile) {
        if(matchDataFile != null){
            try {
                Files.lines(Paths.get(matchDataFile))
                        .forEach(line -> processMatchData(line));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processMatchData(String line) {

    }
}
