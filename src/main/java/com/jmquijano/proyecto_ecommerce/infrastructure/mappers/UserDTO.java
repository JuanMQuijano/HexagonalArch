package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

public record UserDTO(
        String username,
        String firstName,
        String lastName,
        String email
) {
}
