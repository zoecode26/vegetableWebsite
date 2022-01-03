package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.POST })
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
    public Optional<ApplicationUser> getUser(@PathVariable(value = "user_id") Long user) {
        return applicationUserDAO.findById(user);
    }
}

