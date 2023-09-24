package com.example.uek295_backeend.service.implementation;

import com.example.uek295_backeend.entity.Product;
import com.example.uek295_backeend.repository.ProductRepository;
import com.example.uek295_backeend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the ProductService interface.
 * This class handles the core business logic related to the Product entity.
 */
@Service
public class ProductServiceImplementation implements ProductService {

    /**
     * The product repository used to interact with the database.
     */
    @Autowired
    private ProductRepository productRepository;

    /**
     * Creates a new product.
     *
     * @param product The product object to be created.
     * @return The saved product object.
     */
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product.
     * @throws ResourceNotFoundException If the product with the specified ID is not found.
     */
    @Override
    public Product getById(Long id) {
        return productRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }

    /**
     * Retrieves all the products.
     *
     * @return A list of all products.
     */
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * Updates a product's details.
     *
     * @param id  The ID of the product to update.
     * @param productToUpdate  The product object with updated details.
     * @return The updated product.
     * @throws ResourceNotFoundException If the product with the specified ID is not found.
     */
    @Override
    public Product update(Long id, Product productToUpdate) {
        Product product = productRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));

        // Updating the product's details.
        product.setName(productToUpdate.getName());
        product.setDescription(productToUpdate.getDescription());
        product.setPrice(productToUpdate.getPrice());
        product.setActive(productToUpdate.getActive());
        product.setCategory(productToUpdate.getCategory());
        product.setImage(productToUpdate.getImage());
        product.setSku(productToUpdate.getSku());
        product.setStock(productToUpdate.getStock());

        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     * @throws ResourceNotFoundException If the product with the specified ID is not found.
     */
    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("Product with ID " + id + " not found");
        }
        productRepository.deleteById(id.intValue());
    }
}
