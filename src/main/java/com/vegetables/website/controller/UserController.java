package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {
    private ApplicationUserDAO applicationUserDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(ApplicationUserDAO applicationUserDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserDAO = applicationUserDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/{user_id}")
    public Optional<ApplicationUser> getUser(@PathVariable(value = "user_id") Long user) {
        return applicationUserDAO.findById(user);
    }

    @PostMapping("/sign-up")
    public void signUp(ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserDAO.save(user);
    }
}

