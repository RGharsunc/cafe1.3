package com.example.demo.service;

import com.example.demo.entity.OProduct;
import com.example.demo.repository.OProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vardan on 05.09.2017.
 */
@Service
public class OProductService {
    @Autowired
    private OProductRepository oProductRepository;

    public void addOProduct(OProduct oProduct){
        oProductRepository.save(oProduct);
    }
}
