package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.User;

public interface IUserUseCase {

    User createUser(User user);

    User findByEmail(String email);

    User findById(Integer id);

}
