package com.jmquijano.proyecto_ecommerce.domain;

import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ItemCart {

    private Integer idProduct;

    private String nameProduct;

    private Integer quantity;

    private BigDecimal price;

    public BigDecimal getItemTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

}
