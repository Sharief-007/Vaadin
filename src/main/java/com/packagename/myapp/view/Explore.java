package com.packagename.myapp.view;

import com.packagename.myapp.main.Main;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.richtexteditor.RichTextEditor;
import com.vaadin.flow.router.Route;

@Route(value = "explore",layout = Main.class)
public class Explore extends VerticalLayout {
    FlexLayout actions = new FlexLayout();
    RichTextEditor richTextEditor = new RichTextEditor();
    public Explore(){
        setSizeFull();
        setComponents();
    }

    private void setComponents() {
        Button reset = new Button("Reset");
        reset.addThemeVariants(ButtonVariant.LUMO_ERROR);
        Button save = new Button("save");
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        actions.setWidth("100%");
        actions.add(reset,save);
        actions.setJustifyContentMode(JustifyContentMode.BETWEEN);

        richTextEditor.setWidth("100%");

        add(richTextEditor);
        expand(richTextEditor);
    }
}