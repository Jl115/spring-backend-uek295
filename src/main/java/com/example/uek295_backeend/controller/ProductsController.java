package com.example.uek295_backeend.controller;

import com.example.uek295_backeend.database.Product;
import com.example.uek295_backeend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {

    @Autowired
    private ProductService productService;

    // Product GET Mapping by ID
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // Get all products
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAll();
    }

    // Create a product
    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    // Update a product
    @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    // Delete a product
    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "Product with id: " + id + " deleted successfully";
    }
}
