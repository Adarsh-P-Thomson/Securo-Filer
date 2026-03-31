package com.securofiler.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;

public class MainController {

    @FXML
    private TextField filePathField;

    @FXML
    private ComboBox<String> keyMethodCombo;

    @FXML
    private PasswordField passwordField;

    @FXML
    private VBox passwordContainer;

    @FXML
    public void initialize() {
        if (keyMethodCombo != null) {
            keyMethodCombo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                if ("Key Image (Steganographic Seed)".equals(newVal)) {
                    // Update UI for File based key
                    passwordField.setPromptText("Path to Key Image...");
                } else {
                    passwordField.setPromptText("Enter your secure password...");
                }
            });
        }
    }

    @FXML
    private void handleEncrypt() {
        System.out.println("Encrypting " + filePathField.getText() + " with " + keyMethodCombo.getValue());
    }

    @FXML
    private void handleDecrypt() {
        System.out.println("Decrypting...");
    }
}