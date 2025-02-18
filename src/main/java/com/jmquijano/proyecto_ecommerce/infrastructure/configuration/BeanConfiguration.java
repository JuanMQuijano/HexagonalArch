package com.jmquijano.proyecto_ecommerce.infrastructure.configuration;

import com.jmquijano.proyecto_ecommerce.application.CartService;
import com.jmquijano.proyecto_ecommerce.application.IStockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class BeanConfiguration {

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public ValidateStock validateStock(IStockUseCase stockUseCase) {
        return new ValidateStock(stockUseCase);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CartService cartService() {
        return new CartService();
    }
}
