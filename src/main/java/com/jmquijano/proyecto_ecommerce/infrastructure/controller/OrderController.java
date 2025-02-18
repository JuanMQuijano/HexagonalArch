package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.*;
import com.jmquijano.proyecto_ecommerce.domain.*;
import com.jmquijano.proyecto_ecommerce.infrastructure.configuration.ValidateStock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/order")
@Slf4j
public class OrderController {

    private final CartService cartService;
    private final IUserUseCase userUseCase;
    private final IProductUseCase productUseCase;
    private final IOrderUseCase orderUseCase;
    private final IOrderProductUseCase orderProductUseCase;
    private final IStockUseCase stockUseCase;
    private final ValidateStock validateStock;

    public OrderController(CartService cartService, IUserUseCase userUseCase, IProductUseCase productUseCase, IOrderUseCase orderUseCase, IOrderProductUseCase orderProductUseCase, IStockUseCase stockUseCase, ValidateStock validateStock) {
        this.cartService = cartService;
        this.userUseCase = userUseCase;
        this.productUseCase = productUseCase;
        this.orderUseCase = orderUseCase;
        this.orderProductUseCase = orderProductUseCase;
        this.stockUseCase = stockUseCase;
        this.validateStock = validateStock;
    }

    @GetMapping("/summary")
    public String showSummaryOrder(Model model) {
        User user = userUseCase.findById(1);
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        model.addAttribute("user", user);
        return "user/summaryorder";
    }

    @GetMapping("/create")
    public String createOrder() {
        log.info("------> Creating Order <------");
        User user = userUseCase.findById(1);

        Order order = new Order();
        order.setDateCreated(LocalDateTime.now());
        order.setUser(user);

        order = orderUseCase.createOrder(order);

        //OrderProduct
        List<OrderProduct> orderProducts = new ArrayList<>();

        //ItemCart to OrderProduct
        for (ItemCart itemCart : cartService.getItemCarts()) {
            orderProducts.add(new OrderProduct(productUseCase.getProductById(itemCart.getIdProduct()), itemCart.getQuantity(), order));
        }

        //Guardar
        orderProducts.stream().forEach(op -> {
            orderProductUseCase.save(op);
            Stock stock = new Stock();
            stock.setDateCreated(LocalDateTime.now());
            stock.setProduct(op.getProduct());
            stock.setDescription("venta");
            stock.setUnitIn(0);
            stock.setUnitOut(op.getQuantity());
            stockUseCase.saveStock(validateStock.calculateBalance(stock));
        });

        cartService.removeAllItemsCart();

        return "redirect:/home";
    }
}
