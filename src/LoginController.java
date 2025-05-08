package com.projecttest.projecttest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    void handleLogin(ActionEvent event) {
        // Trim inputs to remove accidental whitespace
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Validate inputs
        if (username.isEmpty() || password.isEmpty()) {
            setStatus("Please enter both username and password", Color.RED);
            return;
        }

        try {
            boolean isValid = Database.validateUser(username, password);

            if (isValid) {
                setStatus("Login successful!", Color.GREEN);
                // Proceed to main application view
                navigateTo("main.fxml");
            } else {
                setStatus("Invalid username or password", Color.RED);
            }
        } catch (Exception e) {
            setStatus("Login error occurred", Color.RED);
            e.printStackTrace(); // Log the error for debugging
        }
    }

    @FXML
    void handleGoToRegister(ActionEvent event) {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStatus(String message, Color color) {
        statusLabel.setText(message);
        statusLabel.setTextFill(color);
    }

    private void navigateTo(String fxmlFile) {
        try {
            Stage stage = (Stage) usernameField.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.centerOnScreen(); // Center the window on screen
        } catch (Exception e) {
            setStatus("Failed to load view: " + fxmlFile, Color.RED);
            e.printStackTrace();
        }
    }

}
