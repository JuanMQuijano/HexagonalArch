package com.jmquijano.proyecto_ecommerce.infrastructure.controller;

import com.jmquijano.proyecto_ecommerce.application.IUserUseCase;
import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.domain.UserType;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.UserDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final IUserUseCase userUseCase;

    public AuthController(IUserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @GetMapping("/register")
    public String registerView(UserDTO userDTO) {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDTO user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> log.error("Errors {}", e.getDefaultMessage()));
            return "register";
        }

        userUseCase.createUser(user);
        redirectAttributes.addFlashAttribute("success", "Usuario Creado Correctamente");
        return "redirect:/auth/register";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }

}
