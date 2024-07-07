package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.app.Model.Model;
import javafx.stage.Stage;
import java.io.IOException;

public class DashboardController {

    @FXML
    public Label userLabel;

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
