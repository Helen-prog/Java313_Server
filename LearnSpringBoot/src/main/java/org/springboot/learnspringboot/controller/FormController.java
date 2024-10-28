package org.springboot.learnspringboot.controller;

import org.springboot.learnspringboot.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class FormController {

    @GetMapping("register")
    public String userRegistrationPage(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "HR");
        model.addAttribute("listProfession", listProfession);
        return "register-form";
    }

    @PostMapping("register/save")
    public String registerUser(@ModelAttribute("userForm") UserForm userForm, Model model) {
        model.addAttribute("userForm", userForm);
        return "register-success";
    }
}
