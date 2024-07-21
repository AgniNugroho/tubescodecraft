package com.app.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ResourceBundle;
import java.net.URL;

import com.app.Model.Model;
import com.app.Model.DataAkun;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class AdminController implements Initializable {

    private static final String JSON_FILE_PATH = "src/main/resources/JSON/DataUser.json";

    @FXML
    public Label userLabel;

    @FXML
    public TableView<DataAkun> tvAkun;

    @FXML
    public TableColumn<DataAkun, String> tcId;

    @FXML
    public TableColumn<DataAkun, String> tcUsername;

    @FXML
    public TableColumn<DataAkun, String> tcNamaLengkap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userLabel.setText(Model.getInstance().getAccount().getUsername());
        try {
            loadUserData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setupTableCollumn();
    }
    
    public void onLogout() throws IOException {
        Stage stage = (Stage) userLabel.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getAccount().removeAccount();
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    private void loadUserData() throws Exception {
        File jsonFile = new File(JSON_FILE_PATH);
            
        if (jsonFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(jsonFile))) {
                JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
                for (int i = 0; i < jsonArray.size(); i++) {
                    JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
                    String usernameJson = jsonObject.get("username").getAsString();
                    String namaJson = jsonObject.get("namaLengkap").getAsString();
                    String idJson = jsonObject.get("id").getAsString();
                    DataAkun akun = new DataAkun(idJson, usernameJson, namaJson);
                    tvAkun.getItems().add(akun);
                }
            }
        }
    }

    public void setupTableCollumn() {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        tcNamaLengkap.setCellValueFactory(new PropertyValueFactory<>("namaLengkap"));
    }
}
