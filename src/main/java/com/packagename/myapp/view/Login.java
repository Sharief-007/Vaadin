package com.packagename.myapp.view;

import com.packagename.myapp.main.Main;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "login")
public class Login extends VerticalLayout {
    LoginForm loginForm = new LoginForm();

    public Login() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        loginForm.setAction("login");
        add(loginForm);
    }
}
