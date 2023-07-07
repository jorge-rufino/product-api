package com.rufino.product.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rufino.product.models.ProductModel;
import com.rufino.product.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel save(ProductModel productModel){
        return productRepository.save(productModel);
    }
    
    public List<ProductModel> listar(){
    	return productRepository.findAll();
    }
    
    public ProductModel buscar(UUID idProduct) {
    	return productRepository.findById(idProduct).orElse(null);
    }
}
