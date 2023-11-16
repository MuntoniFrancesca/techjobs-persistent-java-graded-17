package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    //add a private property jobs of type List<Job> and initialize it to an empty ArrayList.
    @OneToMany
    @JoinColumn (name = "employer_id") //Recall that this annotation needs a name parameter. What should its value be?
    private final List<Job> jobs = new ArrayList<>();
    //Employer should have a field called location
    @NotBlank
    @Size(min = 2, max = 100)
    private String location;
    //

    //No args constructor:
    public Employer () {}
    //

    //Add public accessors methods for Employer
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //
}
