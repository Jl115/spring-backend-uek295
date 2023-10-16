package com.example.uek295_backeend.category;

import com.example.uek295_backeend.category.Category;
import com.example.uek295_backeend.category.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category create(Category category);

    CategoryDTO create(CategoryDTO categoryDto);
    CategoryDTO getById(Long id);
    List<CategoryDTO> getAll();
    void updateCategory(int categoryId, CategoryDTO categoryDTO);
    void deleteCategory(int categoryId);

    CategoryDTO update(Long id, CategoryDTO categoryDto);

    void delete(Long id);

    default CategoryDTO convertToDto(Category category) {
        CategoryDTO categoryDto = new CategoryDTO();
        categoryDto.setName(category.getName());
        categoryDto.setActive(category.getActive());
        return categoryDto;
    }

    default Category convertToEntity(CategoryDTO categoryDto) {
        Category category = new Category();
        if (category.getId() != null) {
            category.setId(category.getId());
        }
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.getActive());
        return category;
    }
    void createCategory(CategoryDTO categoryDTO);
    List<Category> getAllCategories();
    Category getCategoryById(int categoryId);

}
