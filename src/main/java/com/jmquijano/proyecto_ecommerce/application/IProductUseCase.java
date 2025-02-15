package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductDTO;

import java.util.List;

public interface IProductUseCase {

    List<ProductDTO> getProducts();

    List<Product> getProductsByUser(User user);

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProductById(Integer id);

}
