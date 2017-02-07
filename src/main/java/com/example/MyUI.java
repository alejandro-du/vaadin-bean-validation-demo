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
        Label error = new Label();
        error.addStyleName(ValoTheme.LABEL_FAILURE);
        Button save = new Button("Save", e -> save());
        save.addStyleName(ValoTheme.BUTTON_PRIMARY);

        FormLayout layout = new FormLayout(title, error, name, start, end, save);
        layout.setMargin(true);
        setContent(layout);

        binder.setStatusLabel(error);
        binder.setBean(meetup);
        binder.bindInstanceFields(this);
    }

    private void save() {
        if (binder.validate().isOk()) {
            Notification.show("Meetup saved: " + meetup);
        }
    }

}
