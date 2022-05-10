package com.vegetables.website.controller;

import com.vegetables.website.dao.BoxDAO;
import com.vegetables.website.model.Box;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boxes", method = { RequestMethod.GET })
public class BoxController {
    private final BoxDAO boxDAO;

    public BoxController(BoxDAO boxDAO) {
        this.boxDAO = boxDAO;
    }

    @GetMapping("")
    public Iterable<Box> getUsers() {
        return boxDAO.findAll();
    }

    @GetMapping("/{box_id}")
    public Optional<Box> getUser(@PathVariable(value = "box_id") Long box_id) {
        return boxDAO.findById(box_id);
    }
}