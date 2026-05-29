package com.example.product_crud_assignment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;

   @Getter
   @Setter
   @NoArgsConstructor
   @AllArgsConstructor
   @Entity
   @Table(name = "products")
   public class Product {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @Column(nullable = false)
       private String name;

       @Column(nullable = false)
       private String description;

       @Column(nullable = false)
       private double price;

        @Column(nullable = false)
       private int quantity;

       public Product(String name, String description, double price, int quantity) {
           this.name = name;
           this.description = description;
           this.price = price;
           this.quantity = quantity;
       }
   }