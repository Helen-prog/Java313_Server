package org.springsecurity.securityregisterlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springsecurity.securityregisterlogin.entity.User;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user) {
        System.out.println(user);
        return "register";
    }
}
