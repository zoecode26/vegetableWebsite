package com.vegetables.website.dao;

import com.vegetables.website.model.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserDAO extends CrudRepository<ApplicationUser, Long> {
    ApplicationUser findByEmail(String email);
}
