package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product("","Banana", "A fruit", 2.99, 100));
        products.add(new Product("","Apple", "A red fruit", 1.99, 50));
        products.add(new Product("", "Orange", "A citrus fruit", 3.99, 75));
    }

    // Save a product to the list.
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    // Return all products.
    public List<Product> findAll() {
        return products;
    }

    // Find a product by its ID.
    public Product findById(String id) {
      for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null; // Return null if the product is not found
    }

    // Update a product by its ID.
    public Product update(String id, Product updatedProduct) {
        int index = getProductIndex(id);
        if (index != -1) {
            products.set(index, updatedProduct);
            return updatedProduct;
        }
        return null; // Return null if the product is not found
    }

    // Delete a product by its ID.
    public void delete(String id) {
        int index = getProductIndex(id);
        if (index != -1) {
            products.remove(index);
        }
    }

    // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}