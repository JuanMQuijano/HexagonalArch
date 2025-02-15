package com.jmquijano.proyecto_ecommerce.infrastructure.repository;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> getProductsByUser(User user);

    Product getProductById(Integer id);

}
