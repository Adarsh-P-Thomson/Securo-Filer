package com.securofiler.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static byte[] readFileToByteArray(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }

    public static void writeByteArrayToFile(File file, byte[] data) throws IOException {
        Files.write(file.toPath(), data);
    }

    public static boolean deleteFile(File file) {
        return file.delete();
    }

    public static boolean createDirectory(Path path) {
        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}