package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/user/cart")
@Slf4j
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add-product")
    public String addProductCart(@RequestParam Integer quantity, @RequestParam Integer idProduct, @RequestParam String nameProduct, @RequestParam BigDecimal price) {
        cartService.addItemCart(quantity, idProduct, nameProduct, price);
        getItemsCart();
        return "redirect:/home";
    }

    private void getItemsCart() {
        cartService.getItemCarts().forEach(
                itemCart -> log.info("Item Cart {}", itemCart)
        );
    }

    @GetMapping
    public String getCart(Model model) {
        getItemsCart();
        model.addAttribute("cart", cartService.getItemCarts());
        model.addAttribute("total", cartService.getTotalCart());
        return "user/cart/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable Integer id) {
        cartService.removeItemCart(id);
        return "redirect:/user/cart";
    }


}
