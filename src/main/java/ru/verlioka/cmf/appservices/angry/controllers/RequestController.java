package ru.verlioka.cmf.appservices.angry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.verlioka.cmf.appservices.angry.model.CommodityEntity;
import ru.verlioka.cmf.appservices.angry.model.CommodityTypeEntity;
import ru.verlioka.cmf.appservices.angry.model.ProvidersEntity;
import ru.verlioka.cmf.appservices.angry.model.SupplyEntity;
import ru.verlioka.cmf.appservices.angry.services.concrete.CommodityService;
import ru.verlioka.cmf.appservices.angry.services.concrete.CommodityTypeService;
import ru.verlioka.cmf.appservices.angry.services.concrete.ProvidersService;
import ru.verlioka.cmf.appservices.angry.services.concrete.SupplyService;

import java.util.*;

@Controller
@EnableTransactionManagement
public class RequestController {

    @Autowired
    private CommodityService commodityService;
    @Autowired
    private CommodityTypeService commodityTypeService;
    @Autowired
    private ProvidersService providersService;
    @Autowired
    private SupplyService supplyService;

    @RequestMapping(value = "/commodity_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommodityEntity> getAll_commodity() {
        List<CommodityEntity> rlist = commodityService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/commodity_type_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<CommodityTypeEntity> getAll_type() {
        List<CommodityTypeEntity> rlist = commodityTypeService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/providers_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProvidersEntity> getAll_providers() {
        List<ProvidersEntity> rlist = providersService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/supply_table", method = RequestMethod.GET)
    public
    @ResponseBody
    List<SupplyEntity> getAll_supply() {
        List<SupplyEntity> rlist = supplyService.getAll();
        return rlist;
    }

    @RequestMapping(value = "/request_1", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> Request() {
        List<SupplyEntity> supply_list = supplyService.getAll();
        List<String> rlist = new ArrayList<String>();

        for(SupplyEntity Entity : supply_list) {
            CommodityEntity commodityEntity = commodityService.find(Entity.getCommodity_id());
            ProvidersEntity providersEntity = providersService.find(Entity.getProvider_id());


            String newEntry = new String();

            newEntry += commodityEntity.getName() + ", ";
            newEntry += commodityEntity.getDescription() + ", ";
            newEntry += commodityEntity.getUnit() + ", ";
            newEntry += commodityEntity.getPrice() + ", ";
            newEntry += providersEntity.getName() + ", ";
            newEntry += providersEntity.getCity() + ", ";
            newEntry += providersEntity.getCountry() + ", ";
            newEntry += providersEntity.getPhone() + ", ";
            newEntry += providersEntity.getFax() + ", ";
            newEntry += (Entity.isShipments_are_stopped() ? "true" : "false") + ", ";
            newEntry += Entity.getCount() + ", ";
            newEntry += Entity.getPrice() + ", ";
            newEntry += Entity.getDate().toString() + "\n";

            rlist.add(newEntry);
        }

        return rlist;
    }

}
