package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    private ApplicationUserDAO applicationUserDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public HomeController(ApplicationUserDAO applicationUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserDAO = applicationUserDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/sign-up")
    public String getSignupPage() {
        return "signup";
    }
}
