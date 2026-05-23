 package com.example.product_crud_assignment;

   import org.springframework.web.bind.annotation.*;

   import java.util.ArrayList;
   import java.util.List;

   @RestController
   @RequestMapping("/products")
   public class ProductController {

       private List<Product> products = new ArrayList<>();

       // Helper method to find the index of a product by ID
    private int getProductIndex(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return products.indexOf(product);
            }
        }
        // Not found
        return -1;
    }

       // method to add a new product
       @PostMapping
       public Product createProduct(@RequestBody Product product) {
           products.add(product);
           return product; // Modify this line to return the added product
       }

       // method to get all products
       @GetMapping
       public List<Product> getAllProducts() {
           return products; // Modify this line to return the list of products
       }

       // method to get a product by ID
       @GetMapping("/{id}")
       public Product getProductById(@PathVariable String id) {
          int index = getProductIndex(id);
          if (index != -1) {
              return products.get(index);
          }
          return null;
       }

       // method to update a product
       @PutMapping("/{id}")
       public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
            int index = getProductIndex(id);
            if (index != -1) {
                products.set(index, updatedProduct);
                return updatedProduct; // Return the updated product
            } else {
           createProduct(updatedProduct); // If product doesn't exist, create a new one
            return updatedProduct; // Return the newly created product
          }
       }

       // method to delete a product
       @DeleteMapping("/{id}")
       public String deleteProduct(@PathVariable String id) {
          int index = getProductIndex(id);
          if (index != -1) {
              products.remove(index);
              return "Product with ID " + id + " was deleted.";
          }
          return "Product with ID " + id + " was not found.";
       }
   }