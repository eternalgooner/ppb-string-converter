package com.eternalgooner.utils;

import java.io.File;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class MyFileUtils {

    private static File dataFile;

    public static boolean checkIfValidFile(String fileName) {
        dataFile = new File(fileName);
        return dataFile.exists();
    }

    public static File getDataFile() {
        return dataFile;
    }
}
