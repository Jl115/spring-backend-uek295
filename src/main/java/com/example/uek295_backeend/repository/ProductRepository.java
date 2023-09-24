package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByName(String name);
}


