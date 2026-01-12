package com.securofiler.controller;

import com.securofiler.service.DecryptionService;
import com.securofiler.util.FileUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.File;

public class DecryptController {

    @FXML
    private TextField keySourceField;

    @FXML
    private TextField fileToDecryptField;

    @FXML
    private Button decryptButton;

    private DecryptionService decryptionService;

    public DecryptController() {
        this.decryptionService = new DecryptionService();
    }

    @FXML
    private void initialize() {
        decryptButton.setOnAction(event -> decryptFile());
    }

    private void decryptFile() {
        String keySourcePath = keySourceField.getText();
        String fileToDecryptPath = fileToDecryptField.getText();

        File keySourceFile = new File(keySourcePath);
        File fileToDecrypt = new File(fileToDecryptPath);

        if (!keySourceFile.exists() || !fileToDecrypt.exists()) {
            showAlert("Error", "Key source or file to decrypt does not exist.");
            return;
        }

        try {
            decryptionService.decrypt(fileToDecrypt, keySourceFile);
            showAlert("Success", "File decrypted successfully.");
        } catch (Exception e) {
            showAlert("Error", "Decryption failed: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}