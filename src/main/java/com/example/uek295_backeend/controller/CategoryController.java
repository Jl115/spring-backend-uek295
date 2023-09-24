package com.example.uek295_backeend.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("category")
public class CategoryController {
    // GET Mapping
    @GetMapping({"/{id}"})
    public String getCategoriesById(@PathVariable String id) {
        return "categories GET specific by ID works id is: " + id;
    }

    @GetMapping({"/"})
    public String getCategories() {
        return "categories GET works";
    }

    // POST Mapping
    @PostMapping("/")
    public String postCategories() {
        return "Categories POST work";
    }

    // Delete Mapping
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable String id) {
        return id + "deleted";
    }
}