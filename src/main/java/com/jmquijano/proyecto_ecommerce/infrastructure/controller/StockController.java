package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.IStockUseCase;
import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.Stock;
import com.jmquijano.proyecto_ecommerce.infrastructure.configuration.ValidateStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {

    private final IStockUseCase stockUseCase;
    private final ValidateStock validateStock;

    @Autowired
    public StockController(IStockUseCase stockUseCase, ValidateStock validateStock) {
        this.stockUseCase = stockUseCase;
        this.validateStock = validateStock;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Product product = new Product();
        product.setId(id);

        List<Stock> stockList = stockUseCase.getStockByProduct(product);
        model.addAttribute("stocks", stockList);
        model.addAttribute("idproduct", id);

        return "admin/stock/show";
    }

    @GetMapping("/create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model) {
        model.addAttribute("idproduct", id);
        return "admin/stock/create";
    }

    @PostMapping("/save-unit-product")
    public String save(Stock stock, @RequestParam("idproduct") Integer idProduct) {
        stock.setDateCreated(LocalDateTime.now());
        stock.setDescription("Inventario");

        Product product = new Product();
        product.setId(idProduct);

        stock.setProduct(product);

        stockUseCase.saveStock(validateStock.calculateBalance(stock));
        return "redirect:/admin/show";
    }

}
