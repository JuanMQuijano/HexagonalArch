package com.jmquijano.proyecto_ecommerce.infrastructure.configuration;

import com.jmquijano.proyecto_ecommerce.application.IStockUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public ValidateStock validateStock(IStockUseCase stockUseCase){
        return new ValidateStock(stockUseCase);
    }


}
