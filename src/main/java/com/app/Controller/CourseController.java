package com.app.Controller;

import com.app.Model.Model;
import javafx.scene.control.Alert;

public class CourseController {

    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }

    public void onCert() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("certificate");
    }

    public void onProfile() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("profile");
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
