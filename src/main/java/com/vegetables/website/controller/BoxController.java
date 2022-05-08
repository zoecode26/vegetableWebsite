package com.vegetables.website.controller;

import com.vegetables.website.dao.BoxDAO;
import com.vegetables.website.model.Box;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/boxes", method = { RequestMethod.GET })
public class BoxController {
    private final BoxDAO boxDAO;

    public BoxController(BoxDAO boxDAO) {
        this.boxDAO = boxDAO;
    }

    @GetMapping("")
    public Iterable<Box> getUsers() {
        System.out.println("REACHING BOXES");
        System.out.println(boxDAO.findAll());
        return boxDAO.findAll();
    }

    @GetMapping("/{box_id}")
    public Optional<Box> getUser(@PathVariable(value = "box_id") Long box_id) {
        return boxDAO.findById(box_id);
    }
}