package com.vegetables.website.controller;

import com.vegetables.website.dao.VegetableDAO;
import com.vegetables.website.model.Vegetable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping(value = "/vegetables", method = { RequestMethod.GET})
public class VegetableController {
    private final VegetableDAO vegetableDAO;

    public VegetableController(VegetableDAO vegetableDAO) {
        this.vegetableDAO = vegetableDAO;
    }

    @GetMapping("")
    public Iterable<Vegetable> getUsers() {
        return vegetableDAO.findAll();
    }

    @GetMapping("/{vegetable_id}")
    public Optional<Vegetable> getUser(@PathVariable(value = "vegetable_id") Long vegetable_id) {
        return vegetableDAO.findById(vegetable_id);
    }
}