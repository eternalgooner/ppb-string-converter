package com.eternalgooner.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 26/09/2019
 **/
public class StringConverterApp {

    private static final Logger LOGGER = LogManager.getLogger(StringConverterApp.class.getName());

    public static void main (String[] args){

        if(args != null){
            String fileName = args[0];
            LOGGER.info("Filename passed as arg: {}", fileName);
        }
        LOGGER.debug("debug log");
    }
}
