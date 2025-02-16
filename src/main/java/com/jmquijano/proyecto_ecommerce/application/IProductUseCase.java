package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IProductUseCase {

    List<ProductDTO> getProducts();

    List<Product> getProductsByUser(User user);

    Product getProductById(Integer id);

    Product saveProduct(Product product, MultipartFile file) throws IOException;

    void deleteProductById(Integer id);

}
