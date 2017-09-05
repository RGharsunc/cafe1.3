package com.example.demo.repository;

import com.example.demo.entity.OProduct;
import com.example.demo.entity.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Created by Vardan on 05.09.2017.
 */
public interface OProductRepository extends JpaRepository<OProduct, Long> {


List<OProduct> findOProductsByReservSet(Set<Reserv> reservs);
}
