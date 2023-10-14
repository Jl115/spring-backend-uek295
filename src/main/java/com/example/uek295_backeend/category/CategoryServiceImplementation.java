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