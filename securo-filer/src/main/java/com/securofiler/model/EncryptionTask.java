package com.securofiler.model;

import java.nio.file.Path;

public class EncryptionTask {
    private Path filePath;
    private String keySource;
    private boolean isEncrypted;

    public EncryptionTask(Path filePath, String keySource) {
        this.filePath = filePath;
        this.keySource = keySource;
        this.isEncrypted = false;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public String getKeySource() {
        return keySource;
    }

    public void setKeySource(String keySource) {
        this.keySource = keySource;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
}