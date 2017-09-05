package com.example.demo.service;

import com.example.demo.entity.CTable;
import com.example.demo.entity.Reserv;
import com.example.demo.entity.Statuss;
import com.example.demo.repository.ReservRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */


@Service
public class ReservService {
    @Autowired
    private ReservRepository reservRepository;


    public List<Reserv> getReservListbyCTable(CTable cTable) {

        return reservRepository.findReservsByCTableByCTableId(cTable);
    }



}
