package com.jmquijano.proyecto_ecommerce.infrastructure.repository;

import com.jmquijano.proyecto_ecommerce.domain.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderProductRepository extends JpaRepository<OrderProduct, Integer> {
}
