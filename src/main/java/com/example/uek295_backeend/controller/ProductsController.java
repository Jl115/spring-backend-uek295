package com.example.uek295_backeend.controller;

import com.example.uek295_backeend.service.ProductService;
import com.example.uek295_backeend.service.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAll();
    }

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDto) {
        return productService.create(productDto);
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDto) {
        return productService.update(id, productDto);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "Product with id: " + id + " deleted successfully";
    }
}
