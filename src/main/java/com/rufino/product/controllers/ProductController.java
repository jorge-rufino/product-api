package com.rufino.product.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rufino.product.dtos.ProductRecordDto;
import com.rufino.product.models.ProductModel;
import com.rufino.product.services.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> salvar(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.salvar(productModel));
    }
    
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> listar(){
    	return ResponseEntity.status(HttpStatus.OK).body(productService.listar());
    }
    
    @GetMapping("/products/{idProduct}")
    public ResponseEntity<Object> buscar(@PathVariable UUID idProduct){
    	var productModel = productService.buscar(idProduct);
    	
    	if(productModel != null) {
    		return ResponseEntity.status(HttpStatus.OK).body(productModel);
    	} else {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
    	}
    }
    
    @PutMapping("/products/{idProduct}")
    public ResponseEntity<Object> alterar(@PathVariable UUID idProduct, @RequestBody @Valid ProductRecordDto productRecordDto ){
    	var productModel = productService.buscar(idProduct);
    	
    	if(productModel == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
    	} 
    	
    	BeanUtils.copyProperties(productRecordDto, productModel);
    	
    	return ResponseEntity.status(HttpStatus.OK).body(productService.salvar(productModel));
    }
    
    @DeleteMapping("/products/{idProduct}")
    public ResponseEntity<Object> deletar(@PathVariable UUID idProduct){
    	var productModel = productService.buscar(idProduct);
    	
    	if(productModel == null) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado!");
    	}
    	
    	productService.deletar(productModel);
    	
    	return ResponseEntity.status(HttpStatus.OK).body("Produto foi deletado com sucesso!");
    }
}
