package com.jrdev.imagerepository.server.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Save uploaded file to new location.
     * @param inputStream
     * @param fileLocation
     * @return true if write was successful. false otherwise.
     */
    public static boolean writeToFile(InputStream inputStream, String fileLocation) {
        boolean result = true;

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(fileLocation));
            while ((read = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();

            logger.info("Saved a new file: " + fileLocation);
        } catch (IOException e) {
            logger.error("Could not save file.", e);
            result = false;
        }

        return result;
    }


}
