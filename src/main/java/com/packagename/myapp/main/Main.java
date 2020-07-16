package com.packagename.myapp.main;

import com.packagename.myapp.view.About;
import com.packagename.myapp.view.Explore;
import com.packagename.myapp.view.Home;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@CssImport("frontend://styles/main.css")
@Theme(value = Lumo.class)
@PWA(
        name = "VaadinFlow",
        shortName = "Vaadin",
        backgroundColor = "#000000",
        offlinePath = "frontend://offline/offline.html",
        offlineResources = {
        "frontend://offline/style.css", "frontend://offline/bg.jpg"
        }
)
public class Main extends AppLayout {

    public Main(){
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        DrawerToggle toggle = new DrawerToggle();
        header.add(toggle);

        H3 name = new H3("FaceBook");
        name.addClassName("name");
        header.add(name);

        HorizontalLayout settingsLayout = new HorizontalLayout();
        settingsLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);


        MenuBar menuBar = new MenuBar();
        menuBar.addClassName("menubar");
        menuBar.setOpenOnHover(true);
        MenuItem profile = menuBar.addItem("Sharief");
        SubMenu subMenu = profile.getSubMenu();
        subMenu.addItem("Account settings",click ->{
            Notification.show("Acoount Settings");
        });
        subMenu.addItem("Logout",click ->{
            Notification.show("logout Settings");
        });
        settingsLayout.add(menuBar);


        header.addAndExpand(settingsLayout);




        addToNavbar(header);
    }

    private void createDrawer() {

        VerticalLayout tabs = new VerticalLayout();
        RouterLink home = new RouterLink("Home",Home.class);
        RouterLink about = new RouterLink("About", About.class);
        RouterLink explore = new RouterLink("Explore", Explore.class);
        tabs.add(home,about,explore);


        addToDrawer(tabs);
    }
}
