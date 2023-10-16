package com.example.uek295_backeend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PostMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
    }
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/categories/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }
    @PutMapping("/categories/{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> updateCategory(@PathVariable int categoryId, @RequestBody CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryId, categoryDTO);
        return ResponseEntity.ok("Category updated successfully");
    }


    // Delete Mapping
    @DeleteMapping("/category/{id}")
    public String deleteCategory(@PathVariable String id) {
        categoryService.delete(Long.parseLong(id));
        return "Category with id: " + id + " deleted successfully";
    }
    @DeleteMapping("/categories/{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }

}
