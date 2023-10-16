package com.example.uek295_backeend.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        return null;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDto) {
        Category category = convertToEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return convertToDto(savedCategory);
    }
    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        // Set other fields if necessary
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
    @Override
    public void updateCategory(int categoryId, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            category.setName(categoryDTO.getName());
            // Update other fields as necessary
            categoryRepository.save(category);
        }
    }
    @Override
    public void deleteCategory(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }
    @Override
    public CategoryDTO getById(Long id) {
        Category category = categoryRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
        return convertToDto(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(this::convertToDto).collect(java.util.stream.Collectors.toList());
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryToUpdate) {
        Category existingCategory = categoryRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Category with ID " + id + " not found"));
        Category updatedCategory = convertToEntity(categoryToUpdate);
        existingCategory.setName(updatedCategory.getName());
        existingCategory.setActive(updatedCategory.getActive());

        Category savedCategory = categoryRepository.save(existingCategory);
        return convertToDto(savedCategory);
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id.intValue())) {
            throw new ResourceNotFoundException("Category with ID " + id + " not found");
        }
        categoryRepository.deleteById(id.intValue());
    }

    @Override
    public CategoryDTO convertToDto(Category category) {
        return CategoryService.super.convertToDto(category);
    }

    @Override
    public Category convertToEntity(CategoryDTO categoryDto) {
        return CategoryService.super.convertToEntity(categoryDto);
    }
}
