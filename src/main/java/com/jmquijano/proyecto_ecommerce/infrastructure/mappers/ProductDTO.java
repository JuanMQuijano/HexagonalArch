package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import java.math.BigDecimal;

public record ProductDTO(
        Integer id,
        String code,
        String name,
        String description,
        String image,
        BigDecimal price
) {
}
