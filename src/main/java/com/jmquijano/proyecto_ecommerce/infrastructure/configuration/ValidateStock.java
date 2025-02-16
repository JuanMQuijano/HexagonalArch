package com.jmquijano.proyecto_ecommerce.infrastructure.configuration;

import com.jmquijano.proyecto_ecommerce.application.IStockUseCase;
import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ValidateStock {

    private final IStockUseCase stockUseCase;

    @Autowired
    public ValidateStock(IStockUseCase stockUseCase) {
        this.stockUseCase = stockUseCase;
    }

    private boolean existBalance(Product product) {
        List<Stock> stockList = stockUseCase.getStockByProduct(product);
        return !stockList.isEmpty();
    }

    public Stock calculateBalance(Stock stock) {
        if (stock.getUnitIn() != 0) {
            if (existBalance(stock.getProduct())) {
                List<Stock> stockList = stockUseCase.getStockByProduct(stock.getProduct());
                Integer balance = stockList.get(stockList.size() - 1).getBalance();
                stock.setBalance(balance + stock.getUnitIn());
            } else {
                stock.setBalance(stock.getUnitIn());
            }
        } else {
            List<Stock> stockList = stockUseCase.getStockByProduct(stock.getProduct());
            Integer balance = stockList.get(stockList.size() - 1).getBalance();
            stock.setBalance(balance - stock.getUnitIn());
        }

        return stock;
    }
}
