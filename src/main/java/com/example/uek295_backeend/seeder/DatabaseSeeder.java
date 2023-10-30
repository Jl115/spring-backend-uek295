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

/**
 * This class is responsible for seeding initial data into the database.
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Seeds the entire database with initial data.
     */
    public void seedDatabase() {
        seedUsers();
        seedCategories();
        seedProducts();
    }

    /**
     * Seeds the User table with initial users.
     */
    private void seedUsers() {
        // Checking if there are fewer than 5 users
        if (userRepository.count() < 5) {
            // Creating and saving admin user
            User admin = new User();
            admin.setName("admin");
            admin.setPassword(bCryptPasswordEncoder.encode("admin123"));
            admin.setAdmin(true);
            userRepository.save(admin);

            // Creating and saving test user 1
            User test1 = new User();
            test1.setName("test1");
            test1.setPassword(bCryptPasswordEncoder.encode("test123"));
            test1.setAdmin(false);
            userRepository.save(test1);

            // Creating and saving test user 2
            User test2 = new User();
            test2.setName("test2");
            test2.setPassword(bCryptPasswordEncoder.encode("test456"));
            test2.setAdmin(false);
            userRepository.save(test2);

            // Creating and saving test user 3
            User test3 = new User();
            test3.setName("test3");
            test3.setPassword(bCryptPasswordEncoder.encode("test789"));
            test3.setAdmin(false);
            userRepository.save(test3);

            // Creating and saving test user 4
            User test4 = new User();
            test4.setName("test4");
            test4.setPassword(bCryptPasswordEncoder.encode("test000"));
            test4.setAdmin(false);
            userRepository.save(test4);
        }
    }

    /**
     * Seeds the Category table with initial categories.
     */
    private void seedCategories() {
        // Checking if there are fewer than 5 categories
        if (categoryRepository.count() < 5) {
            // Creating and saving Electronics category
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            // Creating and saving Clothing category
            Category clothing = new Category();
            clothing.setName("Clothing");
            categoryRepository.save(clothing);

            // Creating and saving Books category
            Category books = new Category();
            books.setName("Books");
            categoryRepository.save(books);

            // Creating and saving Home & Garden category
            Category home = new Category();
            home.setName("Home & Garden");
            categoryRepository.save(home);

            // Creating and saving Sports & Outdoors category
            Category sports = new Category();
            sports.setName("Sports & Outdoors");
            categoryRepository.save(sports);
        }
    }

    /**
     * Seeds the Product table with initial products.
     */
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

    /**
     * This method is executed when the application starts, seeding the database.
     */

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }
}
