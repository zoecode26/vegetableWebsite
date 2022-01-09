package com.vegetables.website.dao;

import com.vegetables.website.model.ApplicationUser;
import com.vegetables.website.model.Vegetable;
import org.springframework.data.repository.CrudRepository;

public interface VegetableDAO extends CrudRepository<Vegetable, Long> {}
