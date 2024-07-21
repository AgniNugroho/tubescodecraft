package com.app.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.app.Model.Model;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ProfileController implements Initializable{

    private static final String JSON_FILE_PATH = "src/main/resources/JSON/DataUser.json";

    @FXML
    public Button dashboardBtn;

    @FXML
    public Label nameLabel;

    @FXML
    public Label usernameLabel;

    @Override
    public void initialize(java.net.URL location, java.util.ResourceBundle resources) {
        nameLabel.setText(Model.getInstance().getAccount().getNamaLengkap());
        usernameLabel.setText(Model.getInstance().getAccount().getUsername());
    }

    public void onDashboard() throws IOException {
        Stage stage = (Stage) dashboardBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showMainWindow();
    }

    public void onChangePassword() {
        Model.getInstance().getViewFactory().showChangePasswordWindow();
    }

    public void onDeleteAccount() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Konfirmasi");
        alert.setHeaderText("Hapus Akun");
        alert.setContentText("Apakah anda yakin ingin menghapus akun ini?");
        alert.showAndWait();

        if (alert.getResult().getText().equals("OK")) {
            Stage stage = (Stage) dashboardBtn.getScene().getWindow();
            Model.getInstance().getViewFactory().removeStage(stage);
            deleteAccount(Model.getInstance().getAccount().getId());
            Model.getInstance().getViewFactory().showLoginWindow();
            return;
        }

    }

    private void deleteAccount(String id) throws IOException {
        File jsonFile = new File(JSON_FILE_PATH);

        if (jsonFile.exists()) {
            JsonArray jsonArray;
            try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
            }
            
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                if (jsonObject.get("id").getAsString().equals(id)) {
                    jsonArray.remove(i);
                    break;
                }
            }
            try (FileWriter file = new FileWriter(jsonFile)) {
                file.write(jsonArray.toString());
                file.flush();
            }
        }
    }
}
