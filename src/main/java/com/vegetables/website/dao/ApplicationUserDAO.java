package com.vegetables.website.dao;

import com.vegetables.website.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserDAO extends CrudRepository<ApplicationUser, String> {
    ApplicationUser findByEmail(String email);
}
