package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import com.app.Model.Model;

public class ChangePasswordController {
    
    @FXML
    public PasswordField oldPasswordField;

    @FXML
    public PasswordField newPasswordField;

    public void onSave() {
        String lama = oldPasswordField.getText();
        String baru = newPasswordField.getText();

        if (lama.equals("") || baru.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Kolom Kosong");
            alert.setContentText("Harap isi semua kolom");
            alert.showAndWait();
            return;
        }

        if (!lama.equals(Model.getInstance().getAccount().getPassword())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Password Lama Salah");
            alert.setContentText("Password lama yang anda masukkan salah");
            alert.showAndWait();
            return;
        }

        Model.getInstance().getAccount().setPassword(baru);
        Model.getInstance().getAccount().saveAccount();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informasi");
        alert.setHeaderText("Berhasil");
        alert.setContentText("Password berhasil diubah");
        alert.showAndWait();

        Stage stage = (Stage) oldPasswordField.getScene().getWindow();
        Model.getInstance().getViewFactory().removeStage(stage);
    }
}