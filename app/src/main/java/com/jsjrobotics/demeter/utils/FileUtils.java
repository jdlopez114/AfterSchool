package com.jsjrobotics.demeter.utils;

import com.jsjrobotics.defaultTemplate.lifecycle.functional.Optional;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
    private static final int ONE_KILOBYTE = 1024;

    public static Optional<String> readFile(File file) {
        char[] buffer = new char[ONE_KILOBYTE];
        FileReader fileStream = null;
        BufferedReader inputStream = null;
        StringBuilder result = new StringBuilder();
        try {
            fileStream = new FileReader(file);
            inputStream = new BufferedReader(fileStream);
            int read = 0;
            while (read != -1) {
                read = inputStream.read(buffer);
                for (int index = 0; index < read; index++) {
                    result.append(buffer[index]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String content = result.toString();
        if (!content.isEmpty()) {
            return Optional.of(content);
        }
        return Optional.empty();
    }

    public static void writeToFile(File file, String content) {
        FileOutputStream fileStream = null;
        BufferedOutputStream outputStream = null;
        try {
            fileStream = new FileOutputStream(file);
            outputStream = new BufferedOutputStream(fileStream);
            outputStream.write(content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
