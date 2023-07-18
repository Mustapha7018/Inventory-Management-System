package com.example.inventorymanagementsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class DashboardController {
    @FXML
    private AnchorPane add_product_form;

    @FXML
    private Button addgoodBtn;

    @FXML
    private Button addgoodBtn1;

    @FXML
    private Button dashboardBtn;

    @FXML
    private Button dashboardBtn1;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Button issuegoodBtn;

    @FXML
    private Button issuegoodBtn1;

    @FXML
    private Button signoutBtn;

    @FXML
    private Button signoutBtn1;

    @FXML
    private Button viewbillBtn;

    @FXML
    private Button viewbillBtn1;

    @FXML
    private Button viewgoodBtn1;

    @FXML
    private Button viewvendorsBtn;

    public void switchForm(ActionEvent event){
        if(event.getSource() == dashboardBtn) {
            dashboard_form.setVisible(true) ;
            add_product_form.setVisible(false);
        }
        else if(event.getSource() == addgoodBtn) {
            dashboard_form.setVisible(false) ;
            add_product_form.setVisible(true);
        }

        else if(event.getSource() == dashboardBtn1) {
            dashboard_form.setVisible(true) ;
            add_product_form.setVisible(false);
        } else if (event.getSource() == addgoodBtn1) {
            dashboard_form.setVisible(false) ;
            add_product_form.setVisible(true);
        }
    }

}

