package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

   //TASK 4.1 In your Skill class, add a jobs field.
    @ManyToMany(mappedBy = "skills")
   private final List<Job> jobs = new ArrayList<>();

    //add a description field
    private String description;

    //no args constructor
    public Skill() {}

    //public access methods
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Add a getter and setter for the field (setter can't be generated ?? )
    public List<Job> getJobs() {
        return jobs;
    }

}
