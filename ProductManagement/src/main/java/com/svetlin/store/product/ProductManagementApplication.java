package com.svetlin.store.product;

import com.svetlin.store.product.domain.Product;
import com.svetlin.store.product.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;

@SpringBootApplication
@EntityScan("com.svetlin.store.product.domain")
public class ProductManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner run(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product()
                    .setName("Pig Meat")
                    .setPrice(BigDecimal.valueOf(10.99))
                    .setQuantity(32)
                    );
            productRepository.save(new Product()
                    .setName("Jack Daniels")
                    .setPrice(BigDecimal.valueOf(70.99))
                    .setQuantity(12)
                    );
            productRepository.save(new Product()
                    .setName("Coca-Cola")
                    .setPrice(BigDecimal.valueOf(1.99))
                    .setQuantity(100)
                    );
            productRepository.save(new Product()
                    .setName("Marlboro")
                    .setPrice(BigDecimal.valueOf(5.20))
                    .setQuantity(50)
                    );
            productRepository.save(new Product()
                    .setName("Cheese")
                    .setPrice(BigDecimal.valueOf(17.99))
                    .setQuantity(90)
                    );
            productRepository.save(new Product()
                    .setName("Vodka")
                    .setPrice(BigDecimal.valueOf(18.99))
                    .setQuantity(122)
                    );
            productRepository.save(new Product()
                    .setName("Chocolate")
                    .setPrice(BigDecimal.valueOf(1.50))
                    .setQuantity(300)
                    );
            productRepository.save(new Product()
                    .setName("Detergent")
                    .setPrice(BigDecimal.valueOf(0.99))
                    .setQuantity(300)
                    );
            productRepository.save(new Product()
                    .setName("Motor Oil")
                    .setPrice(BigDecimal.valueOf(19.99))
                    .setQuantity(200)
                    );
        };
    }
}
