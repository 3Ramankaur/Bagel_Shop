package com.example.javafx_application;

/**
 * @author Gopika Kalathiya(991659883)
 * @author Ramandeep Kaur(991661772)
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink signupHyperLink;


    /**
     * Login button method to open a login window
     * @param event
     * @throws IOException
     */
    @FXML
    public void buttonLogin(ActionEvent event) throws IOException
    {

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent order = FXMLLoader.load(getClass().getResource("TakeOrder.fxml"));
        primaryStage.setTitle("Welcome to Menu");
        primaryStage.setScene(new Scene(order));
        primaryStage.show();
    }

    /**
     * open a signup form
     * @param event
     * @throws IOException
     */

    @FXML
    void lnkSignUp(ActionEvent event) throws IOException {
        Stage stage = (Stage) signupHyperLink.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent signUp = FXMLLoader.load(getClass().getResource("Sign.fxml"));
        primaryStage.setTitle("SignUp Page");
        primaryStage.setScene(new Scene(signUp));
        primaryStage.show();
    }
}

