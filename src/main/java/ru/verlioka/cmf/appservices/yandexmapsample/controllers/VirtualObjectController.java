package ru.verlioka.cmf.appservices.yandexmapsample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;


import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual.VirtualObjectService;

import java.util.List;

@Controller
@EnableTransactionManagement
public class VirtualObjectController {

    @Autowired
    private VirtualObjectService virtualObjectService;


    @RequestMapping(value = "/virtual_object/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    VirtualObject getRole(@PathVariable long id) {
        VirtualObject r = virtualObjectService.find(id);
        return r;
    }

    @RequestMapping(value = "/virtual_object", method = RequestMethod.GET)
    public
    @ResponseBody
    List<VirtualObject> getRoles() {
        List<VirtualObject> rlist = virtualObjectService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/virtual_object/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public
    @ResponseBody
    VirtualObject updateRole(@PathVariable long id, @RequestBody VirtualObject r) {
        return virtualObjectService.modify(r);
    }

    @RequestMapping(value = "/virtual_object", method = RequestMethod.POST, consumes = "application/json")
    public
    @ResponseBody
    VirtualObject addRole(@RequestBody VirtualObject r) {
        return virtualObjectService.add(r);
    }

    @RequestMapping(value = "/virtual_object/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String removeRole(@PathVariable long id) {
        virtualObjectService.remove(id);
        return "OK";
    }
}
