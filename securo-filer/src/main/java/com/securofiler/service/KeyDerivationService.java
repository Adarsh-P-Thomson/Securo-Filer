package com.securofiler.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class KeyDerivationService {

    public byte[] deriveKeyFromText(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(text.getBytes());
    }

    public byte[] deriveKeyFromFile(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] fileBytes = Files.readAllBytes(file.toPath());
        return digest.digest(fileBytes);
    }

    public byte[] deriveKeyFromImage(File imageFile) throws IOException, NoSuchAlgorithmException {
        return deriveKeyFromFile(imageFile);
    }
}