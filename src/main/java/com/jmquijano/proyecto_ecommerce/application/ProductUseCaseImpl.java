package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.Product;
import com.jmquijano.proyecto_ecommerce.domain.User;
import com.jmquijano.proyecto_ecommerce.infrastructure.configuration.UploadFile;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductDTO;
import com.jmquijano.proyecto_ecommerce.infrastructure.mappers.ProductMapper;
import com.jmquijano.proyecto_ecommerce.infrastructure.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductUseCaseImpl implements IProductUseCase {

    private final IProductRepository productRepository;
    private final UploadFile uploadFile;

    @Autowired
    public ProductUseCaseImpl(IProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return ProductMapper.INSTANCE.toDTOs(productRepository.findAll());
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        return productRepository.getProductsByUser(user);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    @Override
    public Product saveProduct(Product product, MultipartFile file) throws IOException {
        if (product.getId() == null) {
            User user = new User();
            user.setId(1);
            product.setUser(user);

            product.setImage(uploadFile.upload(file));

            product.setDataCreated(LocalDateTime.now());
            product.setDataUpdated(LocalDateTime.now());
        } else {
            Product productDB = this.getProductById(product.getId());
            product.setCode(productDB.getCode());
            product.setUser(productDB.getUser());

            product.setDataCreated(productDB.getDataCreated());
            product.setDataUpdated(LocalDateTime.now());

            if (file.isEmpty()) {
                product.setImage(productDB.getImage());
            } else {
                if (!productDB.getImage().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImage());
                }

                product.setImage(uploadFile.upload(file));
            }
        }

        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }
}
