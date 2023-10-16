package com.example.uek295_backeend.seeder;

import com.example.uek295_backeend.category.Category;
import com.example.uek295_backeend.category.CategoryRepository;
import com.example.uek295_backeend.product.Product;
import com.example.uek295_backeend.product.ProductRepository;
import com.example.uek295_backeend.user.User;
import com.example.uek295_backeend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void seedDatabase() {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    private void seedUsers() {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin123"));
            admin.setAdmin((byte) 1); // Set as admin
            userRepository.save(admin);
        }
    }

    private void seedCategories() {
        if (categoryRepository.count() == 0) {
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            Category clothing = new Category();
            clothing.setName("Clothing");
            categoryRepository.save(clothing);

            // Add more categories as needed
        }
    }

    private void seedProducts() {
        if (productRepository.count() == 0) {
            Product phone = new Product();
            phone.setName("Phone");
            phone.setCategory(categoryRepository.findByName("Electronics")); // Assuming you have a method findByName in your CategoryRepository
            productRepository.save(phone);

            Product shirt = new Product();
            shirt.setName("Shirt");
            shirt.setCategory(categoryRepository.findByName("Clothing"));
            productRepository.save(shirt);

            // Add more products as needed
        }
    }

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }
}
