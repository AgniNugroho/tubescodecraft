package com.app.View;

import java.io.IOException;

import com.app.Model.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewFactory {
    
    private final StringProperty selectedMenuItem;
    private AnchorPane dashboardPane;
    private AnchorPane coursePane;
    private AnchorPane certPane;
    private AnchorPane introPane;

    public ViewFactory() {
        this.selectedMenuItem = new SimpleStringProperty("");
    }

    public StringProperty getSelectedMenuItem() {
        return selectedMenuItem;
    }

    private void createStage(FXMLLoader loader, String id) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setTitle("client-"+id);
        Image icon = new Image(getClass().getResourceAsStream("/Picture/icon.png"));
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    public void removeStage(Stage stage) {
        stage.close();
    }
    
    public void showLoginWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/login.fxml"));
        createStage(loader,"");
    }

    public void showMainWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/main.fxml"));
        createStage(loader,Model.getInstance().getAccount().getId());
    }

    public void showRegisterWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/register.fxml"));
        createStage(loader,"");
    }

    public void showAdminWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/admin.fxml"));
        createStage(loader,Model.getInstance().getAccount().getId());
    }

    public void showAssignmentWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/assignment.fxml"));
        createStage(loader,Model.getInstance().getAccount().getId());
    }

    public void showCertificateWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/viewCertificate.fxml"));
        createStage(loader,Model.getInstance().getAccount().getId());
    }

    public void showProfileWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/profile.fxml"));
        createStage(loader, Model.getInstance().getAccount().getId());
    }

    public void showChangePasswordWindow() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/changePassword.fxml"));
        createStage(loader, Model.getInstance().getAccount().getId());
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

    public AnchorPane getCertificateView(){
        if (certPane == null) {
            try {
                certPane = new FXMLLoader(getClass().getResource("/FXML/certificate.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return certPane;

    }

    public AnchorPane getIntroView() {
        if (introPane == null) {
            try {
                introPane = new FXMLLoader(getClass().getResource("/FXML/introduction.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return introPane;
    }

    public void unloadDashboard() {
        dashboardPane = null;
        coursePane = null;
        certPane = null;
        introPane = null;
    }
}
