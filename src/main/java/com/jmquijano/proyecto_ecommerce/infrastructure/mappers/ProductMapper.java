package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "code", target = "code")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "image", target = "image")
    @Mapping(source = "price", target = "price")
    ProductDTO entityToDTO(Product product);

    List<ProductDTO> toDTOs(List<Product> products);
}

