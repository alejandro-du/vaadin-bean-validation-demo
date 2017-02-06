package com.example;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

/**
 * @author Alejandro Duarte
 */
public class MyUI extends UI {

    private TextField name = new TextField("Title");
    private DateField start = new DateField("Start");
    private DateField end = new DateField("End");

    private BeanValidationBinder<Meetup> binder = new BeanValidationBinder<>(Meetup.class);
    private Meetup meetup = new Meetup();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Label title = new Label("Register new Meetup");
        title.addStyleName(ValoTheme.LABEL_H2);
        Button save = new Button("Save", e -> save());

        FormLayout layout = new FormLayout(title, name, start, end, save);
        layout.setMargin(true);
        setContent(layout);
    }

    private void save() {
        binder.setBean(meetup);
        binder.bindInstanceFields(this);

        if (binder.validate().isOk()) {
            Notification.show("Meetup saved: " + meetup);
        }
    }

}
