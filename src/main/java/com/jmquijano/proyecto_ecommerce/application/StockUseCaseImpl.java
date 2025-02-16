package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.Stock;
import com.jmquijano.proyecto_ecommerce.infrastructure.repository.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockUseCaseImpl implements IStockUseCase {

    private IStockRepository stockRepository;

    @Autowired
    public StockUseCaseImpl(IStockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public List<Stock> getStockByProduct(Product product) {
        return stockRepository.getStockByProduct(product);
    }
}
