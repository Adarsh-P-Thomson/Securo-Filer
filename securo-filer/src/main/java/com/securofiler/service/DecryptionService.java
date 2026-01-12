package com.securofiler.service;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class DecryptionService {

    private static final String ALGORITHM = "AES/GCM/NoPadding";
    private static final int TAG_LENGTH_BIT = 128; // 128-bit authentication tag

    public void decryptFile(Path encryptedFilePath, Path outputFilePath, byte[] key) throws Exception {
        Key secretKey = new SecretKeySpec(key, "AES");
        byte[] iv = new byte[12]; // 12-byte IV for GCM
        try (FileInputStream fis = new FileInputStream(encryptedFilePath.toFile())) {
            // Read the IV from the beginning of the file
            fis.read(iv);
            AlgorithmParameterSpec paramSpec = new GCMParameterSpec(TAG_LENGTH_BIT, iv);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, paramSpec);

            try (FileOutputStream fos = new FileOutputStream(outputFilePath.toFile())) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(cipher.update(buffer, 0, bytesRead));
                }
                fos.write(cipher.doFinal());
            }
        }
    }
}