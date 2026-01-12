package com.securofiler.controller;

import com.securofiler.service.EncryptionService;
import com.securofiler.model.EncryptionTask;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ProgressBar;
import javafx.stage.FileChooser;

import java.io.File;

public class EncryptController {

    @FXML
    private TextField keySourceField;

    @FXML
    private TextField fileToEncryptField;

    @FXML
    private Button encryptButton;

    @FXML
    private ProgressBar progressBar;

    private EncryptionService encryptionService;

    public EncryptController() {
        this.encryptionService = new EncryptionService();
    }

    @FXML
    private void initialize() {
        // Initialization logic if needed
    }

    @FXML
    private void selectKeySource() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Key Source");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            keySourceField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void selectFileToEncrypt() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Encrypt");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            fileToEncryptField.setText(selectedFile.getAbsolutePath());
        }
    }

    @FXML
    private void encryptFile() {
        String keySourcePath = keySourceField.getText();
        String filePath = fileToEncryptField.getText();

        if (keySourcePath.isEmpty() || filePath.isEmpty()) {
            // Show error message
            return;
        }

        EncryptionTask task = new EncryptionTask(filePath, keySourcePath);
        progressBar.progressProperty().bind(task.progressProperty());

        task.setOnSucceeded(event -> {
            // Handle successful encryption
            progressBar.progressProperty().unbind();
            progressBar.setProgress(1);
        });

        task.setOnFailed(event -> {
            // Handle encryption failure
            progressBar.progressProperty().unbind();
            progressBar.setProgress(0);
        });

        new Thread(task).start();
    }
}