package com.example.uek295_backeend.repository;

import com.example.uek295_backeend.database.Product;
import com.example.uek295_backeend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findAllByName(String name);
}


