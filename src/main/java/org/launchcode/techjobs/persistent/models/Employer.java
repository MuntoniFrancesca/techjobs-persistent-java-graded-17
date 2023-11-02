package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Employer extends AbstractEntity {

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
