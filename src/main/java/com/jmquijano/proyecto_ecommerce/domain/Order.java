package com.jmquijano.proyecto_ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;

    @ManyToOne
    private User user;

    public void addOrdersProduct(List<OrderProduct> orderProducts) {
        this.setOrderProducts(orderProducts);
    }

    public BigDecimal getTotalOrderPrice() {
        return getOrderProducts().stream().map(p -> p.totalPrice()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
