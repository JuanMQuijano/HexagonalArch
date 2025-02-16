package com.jmquijano.proyecto_ecommerce.infrastructure.repository;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> getStockByProduct(Product product);

}