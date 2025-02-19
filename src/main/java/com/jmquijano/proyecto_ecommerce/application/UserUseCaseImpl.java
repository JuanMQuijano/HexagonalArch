package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.domain.UserType;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.UserDTO;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.UserMapper;
import com.jmquijano.proyecto_ecommerce.infrastructure.repository.IUserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserUseCaseImpl implements IUserUseCase {

    private final IUserRepository userRepository;

    public UserUseCaseImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(UserDTO user) {
        User userN = UserMapper.INSTANCE.toEntity(user);
        userN.setUserType(UserType.USER);
        userN.setDataCreatedAt(LocalDateTime.now());
        userN.setUsername(userN.getEmail());

        return userRepository.save(userN);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ObjectNotFoundException("User", 0));
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("User", id));
    }

    public boolean existsUser(UserDTO userDTO) {
        try {
            userRepository.findByEmail(userDTO.email());
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
