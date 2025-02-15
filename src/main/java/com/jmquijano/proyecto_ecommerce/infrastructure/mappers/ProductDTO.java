package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import java.math.BigDecimal;

public record ProductDTO(
        String code,
        String name,
        String description,
        String image,
        BigDecimal price
) {
}
