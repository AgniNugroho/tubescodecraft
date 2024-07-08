package com.app.Controller;

import com.app.Model.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CourseController {

    @FXML
    public Button dashboardBtn;

    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }

    public void onCert() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("certificate");
    }

    public void onProfile() {
        Stage stage = (Stage) dashboardBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);;
        Model.getInstance().getViewFactory().showProfileWindow();
    }

    public void onIntroduction() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("introduction");
    }

    public void onComingsoon() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText("Materi ini akan disediakan di lain waktu");
        alert.showAndWait();
        return;
    }
}
