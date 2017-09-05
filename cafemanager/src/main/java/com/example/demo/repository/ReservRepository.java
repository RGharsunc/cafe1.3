package com.example.demo.repository;

import com.example.demo.entity.CTable;
import com.example.demo.entity.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
public interface ReservRepository extends JpaRepository<Reserv,Long> {

    List<Reserv> findReservsByCTableByCTableId(CTable cTable);

}
