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
        if (userRepository.count() < 5) {
            User admin = new User();
            admin.setName("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin123"));
            admin.setAdmin(true); // Set as admin
            userRepository.save(admin);

            User test1 = new User();
            test1.setName("test1");
            test1.setPassword(bCryptPasswordEncoder.encode("test123"));
            test1.setAdmin(false); // Not an admin
            userRepository.save(test1);

            User test2 = new User();
            test2.setName("test2");
            test2.setPassword(bCryptPasswordEncoder.encode("test456"));
            test2.setAdmin(false);
            userRepository.save(test2);

            User test3 = new User();
            test3.setName("test3");
            test3.setPassword(bCryptPasswordEncoder.encode("test789"));
            test3.setAdmin(false);
            userRepository.save(test3);

            User test4 = new User();
            test4.setName("test4");
            test4.setPassword(bCryptPasswordEncoder.encode("test000"));
            test4.setAdmin(false);
            userRepository.save(test4);
        }
    }


    private void seedCategories() {
        if (categoryRepository.count() < 5) {
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            Category clothing = new Category();
            clothing.setName("Clothing");
            categoryRepository.save(clothing);

            Category books = new Category();
            books.setName("Books");
            categoryRepository.save(books);

            Category home = new Category();
            home.setName("Home & Garden");
            categoryRepository.save(home);

            Category sports = new Category();
            sports.setName("Sports & Outdoors");
            categoryRepository.save(sports);
        }
    }


    private void seedProducts() {
        if (productRepository.count() < 5) {
            Product phone = new Product();
            phone.setName("Phone");
            phone.setDescription("High-end smartphone with great camera");
            phone.setPrice(799.99f);
            phone.setStock(100);
            phone.setSku("PHN-12345");
            phone.setActive((byte) 1);
            phone.setImage("https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small");
            phone.setCategory(categoryRepository.findByName("Electronics"));
            productRepository.save(phone);

            Product shirt = new Product();
            shirt.setName("Shirt");
            shirt.setDescription("Cotton shirt, red color");
            shirt.setPrice(29.99f);
            shirt.setStock(150);
            shirt.setSku("SRT-12345");
            shirt.setActive((byte) 1);
            shirt.setImage("https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small");
            shirt.setCategory(categoryRepository.findByName("Clothing"));
            productRepository.save(shirt);

            Product book = new Product();
            book.setName("Novel");
            book.setDescription("Best-selling novel by famous author");
            book.setPrice(14.99f);
            book.setStock(80);
            book.setSku("BOK-12345");
            book.setActive((byte) 1);
            book.setImage("https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small");
            book.setCategory(categoryRepository.findByName("Books"));
            productRepository.save(book);

            Product sofa = new Product();
            sofa.setName("Sofa");
            sofa.setDescription("Comfortable 3-seater sofa");
            sofa.setPrice(499.99f);
            sofa.setStock(20);
            sofa.setSku("SFA-12345");
            sofa.setActive((byte) 1);
            sofa.setImage("https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small");
            sofa.setCategory(categoryRepository.findByName("Home & Garden"));
            productRepository.save(sofa);

            Product ball = new Product();
            ball.setName("Football");
            ball.setDescription("Standard size football for professional matches");
            ball.setPrice(19.99f);
            ball.setStock(200);
            ball.setSku("BAL-12345");
            ball.setActive((byte) 1);
            ball.setImage("https://images.t3n.de/news/wp-content/uploads/2022/11/getimgai-ki-bilder.jpg?class=hero-small");
            ball.setCategory(categoryRepository.findByName("Sports & Outdoors"));
            productRepository.save(ball);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }
}
