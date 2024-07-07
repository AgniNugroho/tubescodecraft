package com.app.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.app.Model.Model;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewCertificateController implements Initializable {

    @FXML
    public Label userLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userLabel.setText(Model.getInstance().getAccount().getNamaLengkap());
    }
    
}
