package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import com.jmquijano.proyecto_ecommerce.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    UserDTO entityToDTO(User user);

    List<UserDTO> toDTOs(List<User> users);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "cellPhone", target = "cellPhone")
    @Mapping(source = "password", target = "password")
    User toEntity(UserDTO userDTO);

}
