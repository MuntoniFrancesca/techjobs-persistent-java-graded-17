package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;

@Entity
public class Skill extends AbstractEntity {

    //add a description field
    private String description;

    //no args constructor
    public Skill() {}

    //public access methods
    public String getDescription() {
        return description;
    }
}
