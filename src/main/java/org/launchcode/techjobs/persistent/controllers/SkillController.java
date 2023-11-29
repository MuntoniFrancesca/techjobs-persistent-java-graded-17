package org.launchcode.techjobs.persistent.controllers;

import jakarta.validation.Valid;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//BUILDING THIS CONTROLLER FROM THE BEGINNING
@Controller
@RequestMapping("skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;
    //displayViewSkill

    @GetMapping("/")
    public String index(Model model) {
        List skills = (List<Skill>) skillRepository.findAll();
        model.addAttribute("skills", skills);
        return "skills/index";
    }

    @GetMapping("add")
    public String displayAllSkillForm(Model model) {
        model.addAttribute(new Skill());
        return "skills/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "skills/add";
        } else {
            skillRepository.save(newSkill);
            return "redirect:";
        }
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(Model model, @PathVariable int skillId) {
Optional optSkill = skillRepository.findById(skillId);
if(optSkill.isPresent()) {
    Skill skill = (Skill) optSkill.get();
    model.addAttribute("skill", skill);
    return "skills/view";
} else {
    return "redirect:../";
}

    }
}
