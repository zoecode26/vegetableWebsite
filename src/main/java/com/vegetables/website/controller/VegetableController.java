package com.vegetables.website.controller;

import com.vegetables.website.dao.VegetableDAO;
import com.vegetables.website.model.Vegetable;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/vegetables", method = { RequestMethod.GET})
public class VegetableController {
    private final VegetableDAO vegetableDAO;

    public VegetableController(VegetableDAO vegetableDAO) {
        this.vegetableDAO = vegetableDAO;
    }

    @GetMapping("")
    public Iterable<Vegetable> getVegetables() {
        return vegetableDAO.findAll();
    }

    @GetMapping("/{vegetable_id}")
    public Optional<Vegetable> getVegetable(@PathVariable(value = "vegetable_id") Long vegetable_id) {
        return vegetableDAO.findById(vegetable_id);
    }
}