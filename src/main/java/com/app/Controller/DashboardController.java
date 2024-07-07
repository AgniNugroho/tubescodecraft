package com.app.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import com.app.Model.Model;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController implements Initializable{

    @FXML
    public Label userLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userLabel.setText(Model.getInstance().getAccount().getUsername());
    }

    public void onCourse() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }

    public void onCert() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("certificate");
    }

    public void onProfile() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("profile");
    }

    public void onLogout() throws IOException{
        Stage stage = (Stage) userLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getAccount().removeAccount();
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
}
