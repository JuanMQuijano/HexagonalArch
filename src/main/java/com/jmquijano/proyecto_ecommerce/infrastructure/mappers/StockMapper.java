package com.jmquijano.proyecto_ecommerce.infrastructure.mappers;

import com.jmquijano.proyecto_ecommerce.domain.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StockMapper {

    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);


}

