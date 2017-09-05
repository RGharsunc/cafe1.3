package com.example.demo.service;

import com.example.demo.entity.CTable;
import com.example.demo.entity.User;
import com.example.demo.repository.CTableRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
@Service
public class CTableService {
    @Autowired
    private  CTableRepository cTableRepository;


    public void addCTable(CTable cTable) {
        cTableRepository.save(cTable);
    }

    public List<CTable> getCTableList() {
        return cTableRepository.findAll();
    }

    public List<CTable> getFreeCTableList() {
        return cTableRepository.findAllByUserByUserId(null);

    }

    public void updateCTable(CTable cTable) {
        cTableRepository.save(cTable);

    }

    public List<CTable> getCTablesByUser(User user) {
        return cTableRepository.findAllByUserByUserId(user);
    }

    public List<CTable> getCTablesByUserId(long id) {
        return cTableRepository.findAllByUserByUserIdId(id);
    }

    public CTable getCTablebynName(String name) {
        return cTableRepository.findByName(name);
    }
    public CTable getTableById(long id){
        return cTableRepository.findOne(id);
    }



}
