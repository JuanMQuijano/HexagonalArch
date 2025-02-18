package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.OrderProduct;
import com.jmquijano.proyecto_ecommerce.infrastructure.repository.IOrderProductRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderProductUseCaseImpl implements IOrderProductUseCase {

    private final IOrderProductRepository productRepository;

    public OrderProductUseCaseImpl(IOrderProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        return productRepository.save(orderProduct);
    }

}
