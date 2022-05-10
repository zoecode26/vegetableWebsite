package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final ApplicationUserDAO applicationUserDAO;

    public UserController(ApplicationUserDAO applicationUserDAO) {
        this.applicationUserDAO = applicationUserDAO;
    }

    @GetMapping("")
    public Iterable<ApplicationUser> getUsers() {
        return applicationUserDAO.findAll();
    }

    @GetMapping("/{user_id}")
    public Optional<ApplicationUser> getUser(@PathVariable(value = "user_id") Long user_id) {
        return applicationUserDAO.findById(user_id);
    }
}

