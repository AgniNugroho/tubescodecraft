package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.FileReader;
import java.io.BufferedReader;
import javafx.stage.Stage;
import com.app.Model.Model;

public class LoginController {

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
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/CSV/Account.csv"));

        String line;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals(username)) {
                    if (data[i+1].equals(password)) {
                        Stage stage = (Stage) loginBtn.getScene().getWindow();
                        Model.getInstance().getViewFactory().removeStage(stage);
                        Model.getInstance().getViewFactory().setCurrentUser(username);
                        Model.getInstance().getViewFactory().showMainWindow();
                    }
                }
            }
        }
    }

    public void onRegister() throws Exception{
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();;
    }
}
