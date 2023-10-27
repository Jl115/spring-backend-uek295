package com.example.uek295_backeend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * Controller for category-related operations.
 * This controller provides endpoints for fetching, creating, updating, and deleting categories.
 */
@RestController
@RequestMapping("/api")
@Tag(name = "Category Management", description = "Operations pertaining to categories in the application")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    @GetMapping("/categories")
    @Operation(summary = "Get a list of all categories")
    public List<CategoryDTO> getCategories() {
        return categoryService.getAll();
    }
    @GetMapping("/categories/{categoryId}")
    @Operation(summary = "Get a category by its ID")
    public ResponseEntity<Category> getCategoryById(@PathVariable int categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @PostMapping("/categories")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new category", description = "This can only be done by an admin.")
    public ResponseEntity<String> createCategory(@RequestBody @Parameter(description = "Category object to be added to the database", required = true) CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category created successfully");
    }



    @PutMapping("/categories/{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update an existing category", description = "This can only be done by an admin.")
    public ResponseEntity<String> updateCategory(@PathVariable int categoryId, @RequestBody @Parameter(description = "Updated category object", required = true) CategoryDTO categoryDTO) {
        categoryService.updateCategory(categoryId, categoryDTO);
        return ResponseEntity.ok("Category updated successfully");
    }

    @DeleteMapping("/categories/{categoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete a category", description = "This can only be done by an admin.")
    public ResponseEntity<String> deleteCategory(@PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }
}
