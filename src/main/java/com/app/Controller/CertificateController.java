package com.app.Controller;

import com.app.Model.Model;

public class CertificateController {
    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }
}
