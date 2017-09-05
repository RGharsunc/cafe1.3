package com.example.demo.repository;

import com.example.demo.entity.CTable;
import com.example.demo.entity.OProduct;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */

public interface CTableRepository extends JpaRepository<CTable,Long>{


    List<CTable> findAllByUserByUserId(User user);
    List<CTable> findAllByUserByUserIdId(long id);
    CTable findByName(String name);

//    CTable findByReservByReservId
}
