package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerDomain.events.user.CreatedUserEvent;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.Date;
import java.util.UUID;

public class User extends AggregateRoot {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date date;

    public User(String firstName, String lastName, String email, String password) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.date = new Date();
        this.email = email;
        addDomainEvent(new CreatedUserEvent(this.id, this.date));
    }

    public User(String firstName, String lastName, String email, String password, UUID id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.date = new Date();
        this.email = email;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }
}
