package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a product.
    public Product createProduct(Product product) {
        productRepository.save(product);
        return product; // Return the created product
    }

    // Return all products.
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Return a product by its ID.
    public Product getProductById(String id) {
        return productRepository.findById(id);
    }

    // Update a product by its ID.
    public Product updateProduct(String id, Product updatedProduct) {
        return productRepository.update(id, updatedProduct);
    }

    // Delete a product by its ID.
    public void deleteProduct(String id) {
        productRepository.delete(id);
    }
    };
