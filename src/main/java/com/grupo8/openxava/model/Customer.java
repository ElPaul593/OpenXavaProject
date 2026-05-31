package com.grupo8.openxava.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.openxava.annotations.Required;
import org.openxava.annotations.Tab;
import org.openxava.annotations.View;
import org.openxava.model.Identifiable;

@Entity
@View(members = "name; email")
@Tab(properties = "id, name, email")
public class Customer extends Identifiable {

    @Column(length = 100)
    @Required
    private String name;

    @Column(length = 100)
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}