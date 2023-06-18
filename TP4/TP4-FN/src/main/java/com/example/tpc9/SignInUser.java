package com.example.tpc9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;


public class SignInUser {

    @FXML
    private Label loginMessageLabel;

    @FXML
    public static String username;

    @FXML
    private Label loginMessageLabel2;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private Button buttonLogin;

    @FXML
    private ImageView close;

    public void showArrow(MouseEvent event) throws IOException{
        loginMessageLabel2.setText("Welcome come back ");
    }

    public void closeHome(MouseEvent event) throws IOException {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }

    public void signUpButtonOnAction(ActionEvent e) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        Stage stage = (Stage) signUpButton.getScene().getWindow();
        stage.setScene(new Scene(root, 900,650));
        stage.show();
    }
    public void loginButtonOnAction(ActionEvent e){
        if(!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
            validateLogin();
        }
        else {
            loginMessageLabel.setOpacity(0.62);
            loginMessageLabel.setText("Please enter username and password");
        }
    }


    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getConection();

        try {
            String verifyLogin = "SELECT count(1) from Professors where Username = '" + usernameTextField.getText() + "' AND Password = '" + passwordField.getText() + "';\n";
            String getName = "SELECT Firstname FROM Professors WHERE Username = '" + usernameTextField.getText() + "';\n";
            Statement statement1 = connectDB.createStatement();
            Statement statement2 = connectDB.createStatement();
            ResultSet queryResult = statement1.executeQuery(verifyLogin);
            ResultSet nameResult = statement2.executeQuery(getName);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    while (nameResult.next()) {
                        username = nameResult.getString("Firstname");
                        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("perfil.fxml")));
                            Stage stage = (Stage) buttonLogin.getScene().getWindow();
                            stage.setScene(new Scene(root, 900, 650));
                            stage.show();
                    }
                } else {
                    loginMessageLabel.setOpacity(1);
                    loginMessageLabel.setText("Invalid username/password");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String returnUsername(){
        return username;
    }
public void initialize(){
    passwordField.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.ENTER) {
            if (!usernameTextField.getText().isBlank() && !passwordField.getText().isBlank()) {
                validateLogin();
            } else {
                loginMessageLabel.setOpacity(0.62);
                loginMessageLabel.setText("Please enter username and password");
            }
        }
    });

    }

}