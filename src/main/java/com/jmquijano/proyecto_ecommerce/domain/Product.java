package com.jmquijano.proyecto_ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;

    private LocalDateTime dataCreated;
    private LocalDateTime dataUpdated;

    @ManyToOne
    private User user;

    public Product() {
        this.setCode(UUID.randomUUID().toString());
    }
}
