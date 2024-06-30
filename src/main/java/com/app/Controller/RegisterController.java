package com.app.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.app.Model.Model;
import javafx.stage.Stage;

public class RegisterController {
    
    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;
    
    public void onRegister() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/CSV/Account.csv", true));

        writer.append("\n" + username + "," + password);
        writer.close();

        Stage stage = (Stage) usernameField.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showLoginWindow();
    }
}
