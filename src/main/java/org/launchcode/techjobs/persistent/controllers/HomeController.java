package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.launchcode.techjobs.persistent.models.data.JobRepository;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * Created by LaunchCode
 */
@Controller
public class HomeController {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("title", "MyJobs");

        return "index";
    }

    @GetMapping("add")
    public String displayAddJobForm(Model model) {
	    model.addAttribute("title", "Add Job");
        model.addAttribute(new Job());
        model.addAttribute("employers", employerRepository.findAll());
        return "add";
    }

    //4.2 You’ll need to pass in that attribute value to processAddJobForm in HomeController as a @RequestParam.

    @PostMapping("add")
    public String processAddJobForm(@ModelAttribute @Valid Job newJob,
                                       Errors errors, Model model, @RequestParam int employerId, @RequestParam List<Integer> skills) {
        if (errors.hasErrors()) {
	    model.addAttribute("title", "Add Job");
        model.addAttribute(newJob);
        return "add";
        }
        Optional<Employer> result = employerRepository.findById(employerId);
            if (result.isPresent()) {
                Employer employer = result.get();
                newJob.setEmployer(employer);
            }

            //4.3 Then, to get the skills data from a list of ids (rather than a single id as we did with employer), use the CrudRepository method .findAllById(ids)
            List<Skill> skillObjs = (List<Skill>) skillRepository.findAllById(skills);
            newJob.setSkills(skillObjs);


            return "redirect:";
    }

    @GetMapping("view/{jobId}")
    public String displayViewJob(Model model, @PathVariable int jobId) {

            return "view";
    }

}
