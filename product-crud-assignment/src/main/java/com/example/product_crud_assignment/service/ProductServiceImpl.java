package com.example.product_crud_assignment.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product_crud_assignment.Product;
import com.example.product_crud_assignment.repository.ProductRepository;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Create a product.
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Return all products.
    @Deprecated
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Return a product by its ID.
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Update a product by its ID.
    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
      try {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(existingProduct);
      } catch (RuntimeException e) {
        throw new RuntimeException("Failed to update product: " + e.getMessage());
      }
    }

    // Delete a product by its ID.
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
}
}