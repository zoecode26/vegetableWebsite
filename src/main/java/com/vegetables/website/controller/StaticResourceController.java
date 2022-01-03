package com.vegetables.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StaticResourceController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}
