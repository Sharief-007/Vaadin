package com.packagename.myapp.view;

import com.packagename.myapp.main.Main;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "about",layout = Main.class)
public class About extends VerticalLayout {
    public About(){
        add(new H1("About Page"));
    }
}
