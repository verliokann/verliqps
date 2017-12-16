package ru.verlioka.cmf.appservices.vsidorenkov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.orders.OrdersService;
import ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.productType.ProductTypeService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
@RequestMapping("/vsidorenkov")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductTypeService ProductTypeService;
    @PersistenceContext
     private EntityManager entityManager;

    @RequestMapping(value = "/get1", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetRequest1() {
        return ordersService.GetRequest1();
    }

    @RequestMapping(value = "/get2", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetRequest2() {
        return ordersService.GetRequest2();
    }


    @RequestMapping(value = "/get_criteria1", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetCriteriaRequest1() {
        return ordersService.GetCriteriaRequest1();
    }

    @RequestMapping(value = "/get_criteria2", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetCriteriaRequest2() {
        return ordersService.GetCriteriaRequest2();
    }
}
