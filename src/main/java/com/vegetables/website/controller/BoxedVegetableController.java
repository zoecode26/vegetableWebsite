package com.vegetables.website.controller;

import com.vegetables.website.dao.BoxedVegetableDAO;
import com.vegetables.website.model.BoxedVegetable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/boxed-vegetables", method = { RequestMethod.GET})
public class BoxedVegetableController {
    private final BoxedVegetableDAO boxedVegetableDAO;

    public BoxedVegetableController(BoxedVegetableDAO boxedVegetableDAO) {
        this.boxedVegetableDAO = boxedVegetableDAO;
    }

    @GetMapping("")
    public Iterable<BoxedVegetable> getAllDisplayBoxes() {
        return boxedVegetableDAO.findAll();
    }

    @GetMapping("/{box_id}")
    public List<BoxedVegetable> getDisplayBox(@PathVariable(value = "box_id") Long box_id) {
        Iterable<BoxedVegetable> displayBoxes = boxedVegetableDAO.findAll();
        List selectedDisplayBoxes = new ArrayList();
        for (BoxedVegetable box: displayBoxes) {
            if (box.getBoxId() == box_id) {
                selectedDisplayBoxes.add(box);
            }
        }
        return selectedDisplayBoxes;
    }
}