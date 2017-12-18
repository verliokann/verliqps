package ru.verlioka.cmf.appservices.k0tk0vbol.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.DepartInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.SickInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.services.BolService;

import java.util.List;

/**
 * Created by Max on 14.12.2017.
 */
@Controller
@RequestMapping("/k0tk0v")
public class BolControler {

    @Autowired
    private BolService bolService;

    public BolControler() {
    }

    @RequestMapping(value = "/BolStaffCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<SickInfReq> getBolstaffCriteria(){
        return bolService.getBolStaffCriteria();
    }

    @RequestMapping(value = "/BolstaffHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<SickInfReq> getBolStaffHQL(){
        return bolService.getBolstaffHQL();
    }

    @RequestMapping(value = "/DepartStaffCriteria", method = RequestMethod.GET)
    public @ResponseBody
    List<DepartInfReq> getDepartStaffCriteria(){
        return bolService.getDepartStaffCriteria();
    }

    @RequestMapping(value = "/DepartStaffHQL", method = RequestMethod.GET)
    public @ResponseBody
    List<DepartInfReq> getDepartStaffHQL(){
        return bolService.getDepartStaffHQL();
    }


}
