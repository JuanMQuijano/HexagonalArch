package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.OrderProduct;

public interface IOrderProductUseCase {

    OrderProduct save(OrderProduct orderProduct);

}
