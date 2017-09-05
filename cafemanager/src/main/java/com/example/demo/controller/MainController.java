package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.CTableRepository;
import com.example.demo.service.CTableService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ReservService;
import com.example.demo.service.UserService;
import org.omg.CORBA.Current;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vardan on 05.09.2017.
 */
@Controller
public class MainController {

    @Autowired
   private UserService userService;
    @Autowired
    private  CTableService cTableService;
    @Autowired
    private  ProductService productService;
    @Autowired
    private   ReservService reservService;


    @RequestMapping(value = "/")
    public String main() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public String toHomeJSP() {
        return "home";
    }

    @RequestMapping(value = "/manager")
    public String toManagerJSP(ModelMap modelMap) {
        modelMap.addAttribute("waiters", userService.getUsersListWereRoleIsWAITER());
        modelMap.addAttribute("ctables", cTableService.getFreeCTableList());
        return "manager";
    }


    @RequestMapping(value = "/waiter")
    public String toWaiterJSP(ModelMap modelMap) {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = currentUser.getUsername();


        modelMap.addAttribute("username", name);
        modelMap.addAttribute("ctables", cTableService.getCTablesByUserId(currentUser.getId()));
        modelMap.addAttribute("products", productService.getProductList());
        modelMap.addAttribute("freeTables", getUnReservedCTableList());
        return "waiter";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String printUser() {
        return "login";

    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }



    private List<CTable> getUnReservedCTableList() {

        ArrayList<CTable> cTablesList = null;
        List<CTable> cTables = cTableService.getCTableList();


        for (CTable cTable : cTables) {
            for (Reserv reserv : reservService.getReservListbyCTable(cTable)) {
                if (!reserv.getStatuss().equals(Statuss.CLOSED)) {
                    cTablesList.add(cTable);
                }


            }

        }
        return cTablesList;

    }


}
