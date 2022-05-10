package com.vegetables.website.controller;

import com.vegetables.website.dao.BoxedVegetableDAO;
import com.vegetables.website.model.BoxedVegetable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/boxed-vegetables", method = { RequestMethod.GET})
public class BoxedVegetableController {
    private final BoxedVegetableDAO boxedVegetableDAO;

    public BoxedVegetableController(BoxedVegetableDAO boxedVegetableDAO) {
        this.boxedVegetableDAO = boxedVegetableDAO;
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