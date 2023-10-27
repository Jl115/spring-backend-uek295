package com.example.uek295_backeend.category;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service interface for category-related operations.
 * Provides methods for CRUD operations, conversion between entities and DTOs, and other category services.
 */
@Service
public interface CategoryService {

    /**
     * Creates a new category.
     *
     * @param category The category to be created.
     * @return The created category.
     */
    Category create(Category category);

    /**
     * Creates a new category from a DTO.
     *
     * @param categoryDto The DTO representing the category to be created.
     * @return The DTO of the created category.
     */
    CategoryDTO create(CategoryDTO categoryDto);

    /**
     * Fetches a category by its ID and returns it as a DTO.
     *
     * @param id The ID of the category to be fetched.
     * @return The DTO of the fetched category.
     */
    CategoryDTO getById(Long id);

    /**
     * Fetches all categories and returns them as a list of DTOs.
     *
     * @return A list of category DTOs.
     */
    List<CategoryDTO> getAll();

    /**
     * Updates a category by its ID using the provided DTO.
     *
     * @param categoryId The ID of the category to be updated.
     * @param categoryDTO The DTO containing the updated details of the category.
     */
    void updateCategory(int categoryId, CategoryDTO categoryDTO);

    /**
     * Deletes a category by its ID.
     *
     * @param categoryId The ID of the category to be deleted.
     */
    void deleteCategory(int categoryId);

    /**
     * Updates a category by its ID using the provided DTO.
     *
     * @param id The ID of the category to be updated.
     * @param categoryDto The DTO containing the updated details of the category.
     * @return The updated category as a DTO.
     */
    CategoryDTO update(Long id, CategoryDTO categoryDto);

    /**
     * Deletes a category by its ID.
     *
     * @param id The ID of the category to be deleted.
     */
    void delete(Long id);

    /**
     * Converts a category entity to a DTO.
     *
     * @param category The category entity to be converted.
     * @return The converted category as a DTO.
     */
    default CategoryDTO convertToDto(Category category) {
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setName(category.getName());
        categoryDto.setActive(category.getActive());
        return categoryDto;
    }

    /**
     * Converts a category DTO to an entity.
     *
     * @param categoryDto The category DTO to be converted.
     * @return The converted category as an entity.
     */
    default Category convertToEntity(CategoryDTO categoryDto) {
        Category category = new Category();
        if (category.getId() != null) {
            category.setId(category.getId());
        }
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.getActive());
        return category;
    }

    /**
     * Creates a new category from a DTO.
     *
     * @param categoryDTO The DTO representing the category to be created.
     */
    void createCategory(CategoryDTO categoryDTO);

    /**
     * Fetches all categories.
     *
     * @return A list of all categories.
     */
    List<Category> getAllCategories();

    /**
     * Fetches a category by its ID.
     *
     * @param categoryId The ID of the category to be fetched.
     * @return The fetched category.
     */
    Category getCategoryById(int categoryId);
}
