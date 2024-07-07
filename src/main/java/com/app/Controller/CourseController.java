package com.app.Controller;

import com.app.Model.Model;

public class CourseController {

    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }

    public void onCert() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("certificate");
    }

    public void onProfile() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("profile");
    }
}
