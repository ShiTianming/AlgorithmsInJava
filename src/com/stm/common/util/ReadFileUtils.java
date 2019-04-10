package com.stm.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Author STM
 * Create 3/27/19 11:44 PM
 */
public class ReadFileUtils {

    public static void ReadInputFile(String path) {
        FileInputStream input;
        try {
            input = new FileInputStream(path);
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
