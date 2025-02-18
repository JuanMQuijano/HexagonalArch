package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.repository.IUserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserUseCaseImpl implements IUserUseCase {

    private final IUserRepository userRepository;

    public UserUseCaseImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("User", 0));
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User", id));
    }
}
