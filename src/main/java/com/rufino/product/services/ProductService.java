package com.rufino.product.services;

import com.rufino.product.models.ProductModel;
import com.rufino.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }
}
