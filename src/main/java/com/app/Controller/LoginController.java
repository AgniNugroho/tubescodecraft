package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

import javafx.stage.Stage;
import com.app.Model.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LoginController {

    @FXML
    public Button loginBtn;

    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public Button registerBtn;

    private static final String JSON_FILE_PATH = "src/main/resources/JSON/DataUser.json";

    public void onLogin() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (!username.isEmpty() && !password.isEmpty()) {
            authenticate(username, password);
        } else {
            Alert alertWarning = new Alert(AlertType.WARNING);
            alertWarning.setTitle("Warning");
            alertWarning.setHeaderText("Kolom kosong");
            alertWarning.setContentText("Semua kolom harus diisi!");
            alertWarning.showAndWait();
        }
    }

    public void onRegister() throws Exception{
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showRegisterWindow();;
    }

    @SuppressWarnings("unused")
    public void authenticate(String username, String password) {
        try {
            File jsonFile = new File(JSON_FILE_PATH);
            
            if (jsonFile.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                    JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

                    for (int i = 0; i < jsonArray.size(); i++) {
                        JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                        String usernameJson = jsonObject.get("username").getAsString();
                        String passwordJson = jsonObject.get("password").getAsString();
                        String idJson = jsonObject.get("id").getAsString();
                        Boolean roleJson = jsonObject.get("role").getAsBoolean();
                        String namaJson = jsonObject.get("namaLengkap").getAsString();

                        if (roleJson.equals(true)) {
                            if (username.equals(usernameJson) && password.equals(passwordJson)) {
                                Stage stage = (Stage) loginBtn.getScene().getWindow();
                                Model.getInstance().getViewFactory().removeStage(stage);
                                Model.getInstance().getAccount().setAccount(idJson, roleJson, usernameJson, passwordJson, namaJson);
                                Model.getInstance().getViewFactory().showAdminWindow();
                                return;
                            }
                        
                        } else if (username.equals(usernameJson) && password.equals(passwordJson)) {
                            Stage stage = (Stage) loginBtn.getScene().getWindow();
                            Model.getInstance().getViewFactory().removeStage(stage);
                            Model.getInstance().getAccount().setAccount(idJson, roleJson, usernameJson, passwordJson, namaJson);
                            Model.getInstance().getViewFactory().showMainWindow();
                            return;
                        }
                    }
                    Alert alertWarning = new Alert(AlertType.WARNING);
                    alertWarning.setTitle("Warning");
                    alertWarning.setHeaderText("Login Gagal");
                    alertWarning.setContentText("Username atau password salah!");
                    alertWarning.showAndWait();
                    return;
                }
            }                
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
