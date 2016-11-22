package com.imagerepository.server.utils;


import java.io.*;

public class FileUtils {

    /**
     * Save uploaded file to new location
     * @param uploadedInputStream
     * @param uploadedFileLocation
     */
    public static void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


}
