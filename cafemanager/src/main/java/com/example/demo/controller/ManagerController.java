package com.example.demo.controller;

import com.example.demo.entity.CTable;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.service.CTableService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
@Controller
public class ManagerController {
    @Autowired
    private   UserService userService;
    @Autowired
    private   CTableService cTableService;
    @Autowired
    private  ProductService productService;

    @RequestMapping(value = "/manager/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/ctable/add")
    public String addCTable(@ModelAttribute("ctable") CTable cTable) {
        cTableService.addCTable(cTable);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/product/add")
    public String addProduct(@RequestParam("product") String product) {
        productService.addProduct(product);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/waiter/assign/ctable")
    public String assignCtableForWaiter(@RequestParam("username") String username,
                                        @RequestParam("name") String name) {
       User user=userService.getUserByUsername(username);
       CTable cTable=cTableService.getCTablebynName(name);

        cTable.setUserByUserId(user);
        cTableService.addCTable(cTable);
        return "redirect:/manager";
    }

}
