package com.example.uek295_backeend.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByName(String name);

    List<Product> findByCategoryId(int categoryId);
}


