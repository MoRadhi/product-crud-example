package com.example.product_crud_assignment.service;

import org.springframework.stereotype.Service;

import com.example.product_crud_assignment.Product;

import java.util.List;

@Service
public interface ProductService {
    // Create a product.
    Product createProduct(Product product);

    // Return all products.
    List<Product> getAllProducts();

    // Return a product by its ID.
    Product getProductById(Long id);

    // Update a product by its ID.
    Product updateProduct(Long id, Product updatedProduct);

    // Delete a product by its ID.
    void deleteProduct(Long id);
}
