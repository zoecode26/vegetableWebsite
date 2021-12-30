package com.vegetables.website.controller;

import com.vegetables.website.dao.ApplicationUserDAO;
import com.vegetables.website.model.ApplicationUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private ApplicationUserDAO applicationUserDAO;

    public UserController(ApplicationUserDAO applicationUserDAO) {
        this.applicationUserDAO = applicationUserDAO;
    }

    @GetMapping("/{user_id}")
    public ApplicationUser getUser(@PathVariable(value = "user_id") ApplicationUser user) {
        return user;
    }
}
