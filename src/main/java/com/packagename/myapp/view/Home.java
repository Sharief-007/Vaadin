package com.packagename.myapp.view;

import com.packagename.myapp.main.Main;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@CssImport("frontend://styles/home.css")
@Route(value = "",layout = Main.class)
public class Home extends Div {
    FlexLayout layout = new FlexLayout();
    HorizontalLayout header = new HorizontalLayout();
    HorizontalLayout footer = new HorizontalLayout();
    VerticalLayout body = new VerticalLayout();

    public Home(){
        setLayout();
        addLayouts();
        setComponents();
    }

    private void setComponents() {
        setHeader();
        setBody();
        setFooter();
    }

    private void setLayout() {
        setSizeFull();
        layout.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        layout.setAlignContent(FlexLayout.ContentAlignment.STRETCH);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.START);
        layout.setWidth("100%");
        layout.setSizeFull();
    }
    private void addLayouts() {
        layout.add(header,body,footer);
        layout.expand(body);
        add(layout);
    }
    private void setHeader(){
        H4 chatHeader = new H4("Applicant Name");
        chatHeader.addClassName("chatHeader");
        header.add(chatHeader);
    }
    private void setBody(){
        body.addClassName("body");
    }
    private void setFooter(){
        footer.addClassName("footer");

        TextField messageField = new TextField();
        Button send = new Button(VaadinIcon.PAPERPLANE.create());
        send.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        send.addClickListener(click->{
           if (!messageField.getValue().trim().isEmpty()){
               body.add(new Paragraph(messageField.getValue()));
           }
        });

        footer.add(messageField,send);
        footer.expand(messageField);
    }
}
