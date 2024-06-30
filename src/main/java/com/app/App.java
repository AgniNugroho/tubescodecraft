package com.app;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import com.app.Model.Model;

/**
 * @version 0.1
 * @author CodeCraft Labs
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}