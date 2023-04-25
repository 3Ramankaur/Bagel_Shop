package com.example.javafx_application;

/**
 * @author Gopika Kalathiya(991659883)
 * @author Ramandeep Kaur(991661772)
 * @version 1.0
 */

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;
import java.io.*;

public class FinalPOS extends Application
{
    /**
     * start method to load signUp page.
     * @param primaryStage
     * @throws IOException
     */
    public void start(Stage primaryStage) throws IOException
    {
        Parent signup = FXMLLoader.load(getClass().getResource("Sign.fxml"));
        Scene signupScene = new Scene(signup);
        primaryStage.show();
        primaryStage.setScene(signupScene);
    }

    /**
     * This is the main method.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
