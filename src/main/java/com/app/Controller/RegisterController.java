package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.UUID;

import com.app.Model.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class RegisterController {

    @FXML
    public TextField namaField;
    
    @FXML
    public TextField usernameField;

    @FXML
    public PasswordField passwordField;

    private static final String JSON_FILE_PATH = "src/main/resources/JSON/DataUser.json";
    
    public void onRegister() throws Exception{
        String username = usernameField.getText();
        String password = passwordField.getText();
        String nama = namaField.getText();

        if (username.isEmpty() || password.isEmpty() || nama.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Kolom kosong");
            alert.setContentText("Mohon isi semua kolom");
            return;
        }
        register(UUID.randomUUID().toString(), false, username, password, nama);
    }

    public void register(String id, Boolean role, String username, String password, String nama)  {
        try {
            File jsonFile = new File(JSON_FILE_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(jsonFile));
            JsonElement jsonElement = JsonParser.parseReader(reader);
            reader.close();

            JsonArray userArray = jsonElement.getAsJsonArray();

            try {
                for (JsonElement userElement : userArray) {
                    JsonObject userObject = userElement.getAsJsonObject();
                    if (userObject.get("username").getAsString().equals(username)) {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Warning");
                        alert.setHeaderText("Username sudah terdaftar");
                        alert.setContentText("Mohon gunakan username lain");
                        alert.showAndWait();
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            JsonObject newUserObject = new JsonObject();
            newUserObject.addProperty("id", id);
            newUserObject.addProperty("role", role);
            newUserObject.addProperty("username", username);
            newUserObject.addProperty("password", password);
            newUserObject.addProperty("namaLengkap", nama);

            userArray.add(newUserObject);

            try (FileWriter writer = new FileWriter(jsonFile)) {
                writer.write(userArray.toString());
                writer.flush();
                writer.close();
            }

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informasi");
            alert.setHeaderText("Registrasi Berhasil");
            alert.showAndWait();

            Stage stage = (Stage) namaField.getScene().getWindow();
            Model.getInstance().getViewFactory().removeStage(stage);
            Model.getInstance().getViewFactory().showLoginWindow();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}