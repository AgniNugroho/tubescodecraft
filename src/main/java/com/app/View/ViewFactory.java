package com.app.View;

import java.io.IOException;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    
    private final StringProperty selectedMenuItem;
    private AnchorPane dashboardPane;
    private AnchorPane coursePane;

    public ViewFactory() {
        this.selectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getSelectedMenuItem() {
        return selectedMenuItem;
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void removeStage(Stage stage) {
        stage.close();
    }
    
    public void showLoginWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml"));
        createStage(loader);
    }

    public void showMainWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        createStage(loader);
    }

    public void showRegisterWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/register.fxml"));
        createStage(loader);
    }

    public AnchorPane getDashboardView() {
        if (dashboardPane == null) {
            try {
                dashboardPane = new FXMLLoader(getClass().getResource("/FXML/dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardPane;
    }

    public AnchorPane getCourseView() {
        if (coursePane == null); {
            try {
                coursePane = new FXMLLoader(getClass().getResource("/FXML/course.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return coursePane;
    }
}
