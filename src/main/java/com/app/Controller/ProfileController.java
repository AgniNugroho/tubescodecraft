package com.app.Controller;

import java.io.IOException;

import com.app.Model.Model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfileController {

    @FXML
    public Button dashboardBtn;

    public void onDashboard() throws IOException {
        Stage stage = (Stage) dashboardBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showMainWindow();
    }
}
