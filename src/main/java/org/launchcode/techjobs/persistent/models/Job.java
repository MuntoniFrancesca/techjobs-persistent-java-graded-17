package org.launchcode.techjobs.persistent.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Job extends AbstractEntity {

    @ManyToOne
    private Employer employer;
    private String skills;


    public Job() {
    }

    // Initialize the id and value fields.
    public Job(Employer anEmployer, String someSkills) {
        super();
        this.employer = anEmployer;
        this.skills = someSkills;
    }


    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
