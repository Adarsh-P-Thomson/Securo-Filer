package com.securofiler.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {

    @FXML
    private TextField keySourceField;

    @FXML
    private Button encryptButton;

    @FXML
    private Button decryptButton;

    @FXML
    private Label statusLabel;

    @FXML
    public void initialize() {
        // Initialization logic if needed
    }

    @FXML
    private void handleEncryptButtonAction() {
        // Logic to handle encryption
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Encrypt");
        File file = fileChooser.showOpenDialog(encryptButton.getScene().getWindow());
        if (file != null) {
            // Call encryption service with the selected file and key source
            statusLabel.setText("Encrypting: " + file.getName());
        } else {
            statusLabel.setText("Encryption cancelled.");
        }
    }

    @FXML
    private void handleDecryptButtonAction() {
        // Logic to handle decryption
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Decrypt");
        File file = fileChooser.showOpenDialog(decryptButton.getScene().getWindow());
        if (file != null) {
            // Call decryption service with the selected file and key source
            statusLabel.setText("Decrypting: " + file.getName());
        } else {
            statusLabel.setText("Decryption cancelled.");
        }
    }

    @FXML
    private void handleKeySourceSelection() {
        // Logic to handle key source selection
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Key Source");
        File file = fileChooser.showOpenDialog(keySourceField.getScene().getWindow());
        if (file != null) {
            keySourceField.setText(file.getAbsolutePath());
        }
    }
}