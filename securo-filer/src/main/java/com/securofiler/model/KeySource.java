package com.securofiler.model;

import java.io.File;

public class KeySource {
    private String keyType; // Can be "TEXT", "IMAGE", or "FILE"
    private String keyValue; // The actual key value (e.g., password or file path)
    private File keyFile; // The file associated with the key if applicable

    public KeySource(String keyType, String keyValue) {
        this.keyType = keyType;
        this.keyValue = keyValue;
    }

    public KeySource(String keyType, File keyFile) {
        this.keyType = keyType;
        this.keyFile = keyFile;
    }

    public String getKeyType() {
        return keyType;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public File getKeyFile() {
        return keyFile;
    }

    public boolean isValid() {
        // Add validation logic based on key type
        if ("TEXT".equals(keyType)) {
            return keyValue != null && !keyValue.isEmpty();
        } else if ("IMAGE".equals(keyType) || "FILE".equals(keyType)) {
            return keyFile != null && keyFile.exists();
        }
        return false;
    }
}