package com.app.Controller;

import com.app.Model.Model;

public class CertificateController {

    public void onCourse() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("course");
    }

    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }

    public void onProfile() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("profile");
    }
}
