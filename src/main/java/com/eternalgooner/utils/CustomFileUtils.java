package com.eternalgooner.utils;

import java.io.File;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class CustomFileUtils {

    public static boolean checkIfValidFile(String fileName) {
        File dataFile = new File(fileName);
        return dataFile.exists();
    }

}
