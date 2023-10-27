package com.example.uek295_backeend.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing products.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Retrieves products with the given name.
     *
     * @param name The name of the product.
     * @return A list of products with the given name.
     */
    List<Product> findAllByName(String name);

    /**
     * Retrieves products associated with the given category ID.
     *
     * @param categoryId The ID of the category.
     * @return A list of products in the given category.
     */
    List<Product> findByCategoryId(int categoryId);
}
