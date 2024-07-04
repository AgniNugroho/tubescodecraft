package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.io.FileReader;
import java.io.BufferedReader;
import javafx.stage.Stage;
import com.app.Model.Model;

public class LoginController {

    private Boolean showAlert = true;

    @FXML
    public Button loginBtn;

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button registerBtn;

    public void onLogin() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/CSV/Account.csv"))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                for (int i = 0; i < data.length; i++) {
                    if (data[i].equals(username)) {
                        if (data[i+1].equals(password)) {
                            Stage stage = (Stage) loginBtn.getScene().getWindow();
                            showAlert = false;
                            Model.getInstance().getViewFactory().removeStage(stage);
                            Model.getInstance().getAccount().setCurrentUser(username);
                            Model.getInstance().getViewFactory().showMainWindow();
                        }
                    }
                }
            }
            if (showAlert) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username or password");
                alert.setContentText("Please try again");
                alert.showAndWait();
            }
        }
    }

    public void onRegister() throws Exception{
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();;
    }
}
