package com.example.uek295_backeend.service.implementation;

import com.example.uek295_backeend.entity.Product;
import com.example.uek295_backeend.service.ProductService;
import com.example.uek295_backeend.service.dtos.ProductDTO;

import java.util.List;

public class CategoryServiceImplementation implements ProductService {
    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public ProductDTO create(ProductDTO productDto) {
        return null;
    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ProductDTO> getAll() {
        return null;
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDto) {
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public ProductDTO convertToDto(Product product) {
        return ProductService.super.convertToDto(product);
    }

    @Override
    public Product convertToEntity(ProductDTO productDto) {
        return ProductService.super.convertToEntity(productDto);
    }
}
