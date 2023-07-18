package com.example.inventorymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

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

                    // LINK DASHBOARD
                    loginBtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dashboard.fxml")));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setTitle("INVENTORY MANAGEMENT SYSTEM");
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Incorrect Credential");
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