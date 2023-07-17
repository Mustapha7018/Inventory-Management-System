package com.example.inventorymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML

    private Button loginBtn;

    @FXML
    private AnchorPane main_page;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    // DATABASE TOOLS
    Connection connect;
    PreparedStatement prepare;
    ResultSet result;


    public void  loginAdmin() {
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        connect = database.connectDb();

        try{
            Alert alert;

            if(username.getText().isEmpty() || password.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all the required fields");
                alert.showAndWait();
            }
            else {
                // If authenticated, proceed to dashboard
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, username.getText());
                prepare.setString(2, password.getText());

                result = prepare.executeQuery();
                if (result.next()){
                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("success Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Login Successful");
                    alert.showAndWait();
                }
                else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid Credential");
                    alert.showAndWait();
                }
            }

        }

        catch(Exception e){
            e.printStackTrace();
        }
    }


    // CREATE DATABASE

    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}