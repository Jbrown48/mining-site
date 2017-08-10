package com.jjmining.miningsite.miningsite.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by jarrett on 8/3/2017.
 */

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "created_at")
    private Date createdAt;

    @NotNull
    @Size(min = 1, message = "Name must not be empty")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "Name must not be empty")
    private String lastName;

    @NotNull
    @Min(value = 1, message = "Please enter a valid amount")
    private int budget;

    @Email
    @NotBlank(message = "An email must be included")
    private String email;

    public Customer() {
    }

    public Customer(String firstName, String lastName, int budget, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.budget = budget;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
