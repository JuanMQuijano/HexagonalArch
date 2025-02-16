package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.Stock;

import java.util.List;

public interface IStockUseCase {

    Stock saveStock(Stock stock);

    List<Stock> getStockByProduct(Product product);

}
