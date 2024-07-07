package com.app.Controller;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

import com.app.Model.Model;

public class MainController implements Initializable{
    public BorderPane mainView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getSelectedMenuItem().addListener(observableValue -> {
            switch (Model.getInstance().getViewFactory().getSelectedMenuItem().get()) {
                case "dashboard":
                    mainView.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                    break;
                case "course":
                    mainView.setCenter(Model.getInstance().getViewFactory().getCourseView());
                    break;
                case "certificate":
                    mainView.setCenter(Model.getInstance().getViewFactory().getCertificateView());
                    break;
                case "introduction":
                    mainView.setCenter(Model.getInstance().getViewFactory().getIntroView());
                    break;
                default:
                    break;
            }
        });
    }
}
