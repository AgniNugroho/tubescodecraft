package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.app.Model.Model;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class DashboardController implements Initializable {

    @FXML
    public Label greetLabel, classStatus;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        greetLabel.setText("Selamat Datang, " + Model.getInstance().getAccount().getUsername());
        if (Model.getInstance().getAccount().getC1Score() >= 75) {
            classStatus.setText("Lulus");
        } else {
            classStatus.setText("Belum Lulus");
        }
    }

    public void onCourse() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }

    public void onCert() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("certificate");
    }

    public void onProfile() {
        Stage stage = (Stage) greetLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showProfileWindow();
    }

    public void onLogout() throws IOException{
        Stage stage = (Stage) greetLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getAccount().saveAccount();
        Model.getInstance().getAccount().removeAccount();
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
}
