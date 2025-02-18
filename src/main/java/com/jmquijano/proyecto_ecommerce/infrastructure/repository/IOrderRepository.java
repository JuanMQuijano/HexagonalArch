package com.jmquijano.proyecto_ecommerce.infrastructure.repository;

import com.jmquijano.proyecto_ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}