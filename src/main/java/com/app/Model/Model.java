package com.app.Model;

import com.app.View.ViewFactory;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    private final Account account;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.account = new Account();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }
        return model;
    }
    
    public ViewFactory getViewFactory() {
        return viewFactory;
    }

    public Account getAccount() {
        return account;
    }
}