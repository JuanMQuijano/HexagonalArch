package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "Nombre es requerido")
        String firstName,
        @NotBlank(message = "Apellido es requerido")
        String lastName,
        @Email(message = "Debe ingresar un email validado")
        String email,
        @NotBlank(message = "Dirección es requerido")
        String address,
        @NotBlank(message = "Número de teléfono es requerido")
        String cellPhone,
        @NotBlank(message = "Password es requerido")
        String password
) {
}
