package com.example.uek295_backeend.product;

import com.example.uek295_backeend.product.ProductService;
import com.example.uek295_backeend.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductsController {

    @Autowired
    private ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }


    @PostMapping("/products")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> createProduct(@RequestBody ProductDTO productDTO) {
        productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
    }


    @PutMapping("/products/{productId}")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> updateProduct(@PathVariable Long productId, @RequestBody ProductDTO productDTO) {
        productService.update(productId, productDTO);
        return ResponseEntity.ok("Product updated successfully");
    }
    @DeleteMapping("/products/{productId}")
    @PreAuthorize("hasRole('ADMIN')")  // Ensure that only admins can access this endpoint
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Product deleted successfully");
    }



}
