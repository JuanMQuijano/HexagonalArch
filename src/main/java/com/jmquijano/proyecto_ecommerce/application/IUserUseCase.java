package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.UserDTO;

public interface IUserUseCase {

    User createUser(UserDTO user);

    User findByEmail(String email);

    User findById(Integer id);

}
