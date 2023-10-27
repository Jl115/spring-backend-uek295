package com.example.uek295_backeend.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository interface for the Category entity.
 * Provides CRUD operations and custom query methods for categories.
 */
@Service
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    /**
     * Fetches all categories with a given name.
     *
     * @param name The name of the categories to be fetched.
     * @return A list of categories with the given name.
     */
    List<Category> findAllByName(String name);

    /**
     * Fetches a category with a given name.
     *
     * @param electronics The name of the category to be fetched. (Note: Parameter name seems to be specific, consider renaming it)
     * @return A category with the given name.
     */
    Category findByName(String electronics);
}
