package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByName(String name);
}


