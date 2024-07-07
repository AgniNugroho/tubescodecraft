package com.app.Controller;

import com.app.Model.Model;

public class ProfileController {
    public void onDashboard() {
        Model.getInstance().getViewFactory().getSelectedMenuItem().set("dashboard");
    }
}
