package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vardan on 05.09.2017.
 */
public interface ProductRepository extends JpaRepository<Product,Long> {



}
