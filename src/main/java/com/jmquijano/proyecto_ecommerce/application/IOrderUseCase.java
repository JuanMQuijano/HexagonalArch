package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Order;

import java.util.List;

public interface IOrderUseCase {

    Order createOrder(Order order);

    List<Order> getOrders();

}
