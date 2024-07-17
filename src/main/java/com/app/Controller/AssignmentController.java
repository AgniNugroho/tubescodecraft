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

        double score = Model.getInstance().getAccount().getProgress();
        if (rb1Benar.isSelected()) {
            score += 0.125;
        }
        if (rb2Salah.isSelected()) {
            score += 0.125;
        }
        if (rb3Benar.isSelected()) {
            score += 0.125;
        }
        if (rb4Benar.isSelected()) {
            score += 0.125;
        }

        Stage stage = (Stage) submitBtn.getScene().getWindow();
        Model.getInstance().getAccount().setProgress(score);
        Model.getInstance().getViewFactory().removeStage(stage);
        Model.getInstance().getViewFactory().showMainWindow();
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }
}
