package com.example.demo.controller;

/**
 * Created by Vardan on 05.09.2017.
 */

import com.example.demo.entity.CTable;
import com.example.demo.entity.OProduct;
import com.example.demo.entity.Reserv;
import com.example.demo.entity.Statuss;
import com.example.demo.service.CTableService;
import com.example.demo.service.OProductService;
import com.example.demo.service.ReservService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WaiterController {


    @Autowired
    private UserService userService;
    @Autowired
    private   CTableService cTableService;
    @Autowired
    private  OProductService oProductService;
    @Autowired
    private   ReservService reservService;

    @RequestMapping(value = "/waiter/reserv/add")
    public String addReserv(@ModelAttribute("reserv") Reserv reserv,
                            @RequestParam("id") long id) {
        CTable cTable=cTableService.getTableById(id);
        List<Reserv> reservList=reservService.getReservListbyCTable(cTable);
        reservList.add(reserv);
        return "redirect:/waiter";

    }


    @RequestMapping(value = "/waiter/oProduct/add")
    public String addOrderedProduct(@ModelAttribute("oproduct") OProduct oProduct) {
        oProductService.addOProduct(oProduct);


        return "redirect:/waiter";

    }



}
