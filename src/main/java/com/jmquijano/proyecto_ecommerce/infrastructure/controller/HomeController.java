package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.IProductUseCase;
import com.jmquijano.proyecto_ecommerce.application.IStockUseCase;
import com.jmquijano.proyecto_ecommerce.domain.Stock;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final IProductUseCase productUseCase;
    private final IStockUseCase stockUseCase;

    public HomeController(IProductUseCase productUseCase, IStockUseCase stockUseCase) {
        this.productUseCase = productUseCase;
        this.stockUseCase = stockUseCase;
    }

    @GetMapping
    public String home(Model model) {
        List<ProductDTO> products = productUseCase.getProducts();
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/product-detail/{id}")
    public String getDetail(@PathVariable Integer id, Model model) {
        List<Stock> stocks = stockUseCase.getStockByProduct(productUseCase.getProductById(id));
        Integer lastBalance = stocks.get(stocks.size() - 1).getBalance();

        model.addAttribute("product", productUseCase.getProductById(id));
        model.addAttribute("stock", lastBalance);
        return "user/productdetail";
    }


}
