package com.example.javafx_application;

/**
 * @author Gopika Kalathiya(991659883)
 * @author Ramandeep Kaur()
 * @version 1.0
 */

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class SignUpController {
    @FXML
    private Button signupButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField contactTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Hyperlink userHyperLink;

    static File myFile = new File("UserLoginData.txt");

    public void onSignUpButton(ActionEvent event){
        if (nameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || contactTextField.getText().isEmpty()) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error message");
            alert.setContentText("You have not entered any of the value. Please check it again.");
            alert.show();
        }
        else{
            try{
                PrintWriter output=new PrintWriter(new BufferedWriter(new FileWriter(myFile,true))); // to open file in write mode
                String name = nameTextField.getText();
                String contact = contactTextField.getText();
                String email = emailTextField.getText();
                String passwd = passwordTextField.getText();

                output.println("name:: "+ name+" | Contact No.: " +contact+" | Email ID:: "+email+" | Password:: "+passwd+" | ");

                nameTextField.clear();
                passwordTextField.clear();
                contactTextField.clear();
                emailTextField.clear();

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information message");
                alert.setContentText("Thank you for registering with us.");
                alert.showAndWait().ifPresent(response -> {
                    if(response==ButtonType.OK)
                    {
                        try {
                            Stage stage = (Stage) signupButton.getScene().getWindow();
                            stage.close();
                            Stage primaryStage = new Stage();
                            Parent order = FXMLLoader.load(getClass().getResource("TakeOrder.fxml"));
                            primaryStage.setTitle("Welcome to Menu");
                            primaryStage.setScene(new Scene(order));
                            primaryStage.show();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
                output.close();
            }
            catch (IOException e) //to catch the IOException and to avoid program from crashing
            {
                System.out.println(" Error in file read " + e.getMessage());
            }
            catch (InputMismatchException e) //to catch the MisMatchException and to avoid program from crashing
            {
                System.out.println("Invalid Input " + e.getMessage());
            }
        }
    }

    @FXML
    void  lnkLogin(ActionEvent event) throws IOException {
        Stage stage = (Stage) userHyperLink.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(login));
        primaryStage.show();
    }
}
