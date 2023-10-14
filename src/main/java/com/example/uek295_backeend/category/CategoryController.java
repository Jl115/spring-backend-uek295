package com.example.uek295_backeend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // GET Mapping
    @GetMapping({"/category/{id}"})
    public CategoryDTO getCategoriesById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @GetMapping({"/category"})
    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }

    // POST Mapping
    @PostMapping("/category")
    public CategoryDTO createCategory(@RequestBody CategoryDTO category) {
        return categoryService.create(category);
    }

    // Delete Mapping
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.delete(Long.parseLong(id));
        return "Category with id: " + id + " deleted successfully";
    }
}
