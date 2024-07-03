package com.app.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.app.Model.Model;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
    
    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;
    
    public void onRegister() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/CSV/Account.csv", true));

        if (username.isEmpty() || password.isEmpty()) {
            Alert alertWarning = new Alert(AlertType.WARNING);
            alertWarning.setTitle("Warning");
            alertWarning.setHeaderText("Empty Fields");
            alertWarning.setContentText("Please fill in all fields");
            alertWarning.showAndWait();
        } else {
            Alert alertConf = new Alert(AlertType.CONFIRMATION);
            alertConf.setTitle("Confirmation");
            alertConf.setHeaderText("Account Confirmation");
            alertConf.setContentText("Are you sure all the information is correct?");
            alertConf.showAndWait();
            if (alertConf.getResult().getText().equals("OK")) {
                writer.write("\n" + username + "," + password);
                writer.close();
                Alert alertInfo = new Alert(AlertType.INFORMATION);
                alertInfo.setTitle("Information");
                alertInfo.setHeaderText("Account Created");
                alertInfo.setContentText("Account has been created successfully");
                alertInfo.showAndWait();

                Stage stage = (Stage) usernameField.getScene().getWindow();
                Model.getInstance().getViewFactory().removeStage(stage);
                Model.getInstance().getViewFactory().showLoginWindow();
            }
        }
    }
}
