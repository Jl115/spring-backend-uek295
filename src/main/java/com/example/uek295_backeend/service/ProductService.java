package com.example.uek295_backeend.service;

import com.example.uek295_backeend.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for product-related operations.
 * This interface defines the contract for product operations like creation, retrieval, update, and deletion.
 */
@Service
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param product The product object to be created.
     * @return The saved product object.
     */
    Product create(Product product);

    /**
     * Retrieves a product by its ID.
     *
     * @param id The ID of the product to retrieve.
     * @return The retrieved product.
     */
    Product getById(Long id);

    /**
     * Retrieves all the products.
     *
     * @return A list of all products.
     */
    List<Product> getAll();

    /**
     * Updates a product's details.
     *
     * @param id      The ID of the product to update.
     * @param product The product object with updated details.
     * @return The updated product.
     */
    Product update(Long id, Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param id The ID of the product to delete.
     */
    void delete(Long id);
}
