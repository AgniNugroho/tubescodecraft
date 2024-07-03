package com.app.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import com.app.Model.Model;

public class DashboardController implements Initializable{

    @FXML
    public Label userLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userLabel.setText("Welcome, " + Model.getInstance().getAccount().getCurrentUser());
    }
    
}
