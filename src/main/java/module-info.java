module com.app {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens com.app to javafx.fxml;
    exports com.app;
    exports com.app.View;
    exports com.app.Model;
    exports com.app.Controller;
}
