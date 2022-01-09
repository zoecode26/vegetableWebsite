package com.vegetables.website.controller;

import com.vegetables.website.dao.BoxedVegetableDAO;
import com.vegetables.website.model.DisplayBox;
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
    public List<DisplayBox> getAllDisplayBoxes() {
        return boxedVegetableDAO.findAllDisplayBoxes();
    }

    @GetMapping("/{box_id}")
    public List<DisplayBox> getDisplayBox(@PathVariable(value = "box_id") Long box_id) {
        List<DisplayBox> displayBoxes = boxedVegetableDAO.findAllDisplayBoxes();
        List selectedDisplayBoxes = new ArrayList();
        for (DisplayBox box: displayBoxes) {
            if (box.getBox_id() == box_id) {
                selectedDisplayBoxes.add(box);
            }
        }
        return selectedDisplayBoxes;
    }
}