package com.app.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import com.app.Model.Model;

public class AssignmentController {



    @FXML
    public Button submitBtn;

    @FXML
    public RadioButton rb1Benar, rb2Salah, rb3Benar, rb4Benar;
    
    public void onSubmit() throws Exception{

        int score = 0;
        if (rb1Benar.isSelected()) {
            score += 25;
        }
        if (rb2Salah.isSelected()) {
            score += 25;
        }
        if (rb3Benar.isSelected()) {
            score += 25;
        }
        if (rb4Benar.isSelected()) {
            score += 25;
        }

        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getAccount().setC1Score(score);
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showMainWindow();
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }
}
