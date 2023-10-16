package com.example.uek295_backeend.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public ProductDTO create(ProductDTO productDto) {
        Product product = convertToEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return convertToDto(savedProduct);
    }

    @Override
    public ProductDTO getById(Long id) {
        Product product = productRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
        return convertToDto(product);
    }
    @Override
    public void createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        // Set other fields as necessary
        productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
    @Override
    public void updateProduct(int productId, ProductDTO productDTO) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            // Update other fields as necessary
            productRepository.save(product);
        }
    }
    @Override
    public List<ProductDTO> getAll() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDtoToUpdate) {
        Product existingProduct = productRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));

        Product productToUpdate = convertToEntity(productDtoToUpdate);

        existingProduct.setName(productToUpdate.getName());
        existingProduct.setDescription(productToUpdate.getDescription());
        existingProduct.setPrice(productToUpdate.getPrice());
        existingProduct.setActive(productToUpdate.getActive());
        existingProduct.setImage(productToUpdate.getImage());
        existingProduct.setStock(productToUpdate.getStock());

        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDto(updatedProduct);
    }

    @Override
    public Product update(Long id, Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
        productRepository.deleteById(id.intValue());
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return productRepository.findByCategoryId(categoryId);
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
