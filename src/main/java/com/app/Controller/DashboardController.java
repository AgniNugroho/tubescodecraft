package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import com.app.Model.Model;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class DashboardController implements Initializable {

    @FXML
    public Label greetLabel;
    
    @FXML
    public ProgressBar introProgressBar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        greetLabel.setText("Selamat Datang, " + Model.getInstance().getAccount().getUsername());
        introProgressBar.setProgress(Model.getInstance().getAccount().getProgress());
    }

    public void onCourse() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }

    public void onCert() {
        if (Model.getInstance().getAccount().getProgress() >= 0.7) {
            Model.getInstance().getViewFactory().showCertificateWindow();
            return;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText("Anda belum menyelesaikan materi ini.");
            alert.showAndWait();
            return;
        }
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
        Model.getInstance().getViewFactory().unloadApp();
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
}
