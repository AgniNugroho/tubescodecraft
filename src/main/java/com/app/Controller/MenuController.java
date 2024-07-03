package com.app.Controller;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import com.app.Model.Model;
import javafx.fxml.FXML;

public class MenuController {

    @FXML
    public Button logoutBtn;

    public void onLogout() throws Exception{
        Model.getInstance().getAccount().setCurrentUser(null);
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
    
}
