package com.example.product_crud_assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

   @Getter
   @Setter
   @NoArgsConstructor
   public class Product {
       private String id;
       private String name;
       private String description;
       private double price;
       private int quantity;

       public Product(String id, String name, String description, double price, int quantity) {
           this.id = (id == null || id.isEmpty()) ? UUID.randomUUID().toString() : id;
           this.name = name;
           this.description = description;
           this.price = price;
           this.quantity = quantity;
       }

       public Product(String id) {
        this.id = UUID.randomUUID().toString();
       }
   }