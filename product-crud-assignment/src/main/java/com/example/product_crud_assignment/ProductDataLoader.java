package com.example.product_crud_assignment;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import com.example.product_crud_assignment.repository.ProductRepository;

@Component
public class ProductDataLoader {

    private final ProductRepository productRepository;

    @Autowired
    public ProductDataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void loadData() {
        // Clear out old entries
        productRepository.deleteAll();

        productRepository.save(new Product("Gaming Laptop", "High performance RTX 4070 laptop", 1299.99, 15));
        productRepository.save(new Product("Mechanical Keyboard", "Wireless RGB hot-swappable keyboard", 89.49, 45));
        productRepository.save(new Product("Gaming Mouse", "Ultra lightweight 26K DPI gaming mouse", 59.99, 60));
        productRepository.save(new Product("4K Monitor", "32-inch IPS 144Hz refresh rate display", 449.99, 10));
    }
}