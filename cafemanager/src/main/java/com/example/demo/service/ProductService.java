package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
@Service
public class ProductService {
    @Autowired
    private  ProductRepository productRepository;

    public void  addProduct(String name){
        Product product=new Product();
        product.setName(name);
        productRepository.save(product);
    }

    public List<Product> getProductList(){
        return productRepository.findAll();
    }



}
