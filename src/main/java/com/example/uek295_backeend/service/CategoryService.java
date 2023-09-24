package com.example.uek295_backeend.service;


import com.example.uek295_backeend.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category create(Category category);

    Category getById(Long id);

    List<Category> getAll();

    Category update(Long id, Category category);

    void delete(Long id);
}
