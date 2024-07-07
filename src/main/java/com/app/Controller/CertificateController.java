package com.app.Controller;

import com.app.Model.Model;

import javafx.scene.control.Alert;

public class CertificateController {

    public void onCourse() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }

    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }

    public void onProfile() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("profile");
    }

    public void onComingsoon() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText("Materi ini akan disediakan di lain waktu");
        alert.showAndWait();
        return;
    }

    public void onIntroduction() {
        if (Model.getInstance().getAccount().getC1Score() >= 75) {
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
}
