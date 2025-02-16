package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.IProductUseCase;
import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    private final IProductUseCase productUseCase;

    @Autowired
    public AdminController(IProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @GetMapping
    public String home(Model model) {
        List<ProductDTO> products = productUseCase.getProducts();

        model.addAttribute("products", products);

        return "admin/home";
    }

    @GetMapping("/create")
    public String createPage() {
        return "admin/products/create";
    }

    @PostMapping("/create")
    public String saveProduct(Product product, @RequestParam("img") MultipartFile file) throws IOException {
        productUseCase.saveProduct(product, file);
        return "redirect:/admin";
        //return "admin/products/create";
    }

    @GetMapping("/show")
    public String showProducts(Model model) {
        User user = new User();
        user.setId(1);

        List<Product> products = productUseCase.getProductsByUser(user);
        model.addAttribute("products", products);

        return "admin/products/show";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model) {
        Product product = productUseCase.getProductById(id);

        model.addAttribute("product", product);

        return "admin/products/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        productUseCase.deleteProductById(id);
        return "redirect:/admin/show";
    }
}