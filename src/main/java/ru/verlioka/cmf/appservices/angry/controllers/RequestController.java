package ru.verlioka.cmf.appservices.angry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/angry")
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
    String Request1() {
        List<SupplyEntity> supply_list = supplyService.getAll();
        String JSON_String = new String();
        JSON_String = "[";
        boolean isFirst = true;
        for(SupplyEntity Entity : supply_list) {
            CommodityEntity commodityEntity = commodityService.find(Entity.getCommodity_id());
            ProvidersEntity providersEntity = providersService.find(Entity.getProvider_id());
        if(isFirst) isFirst = false; else JSON_String +=",";
            JSON_String += "{";
            JSON_String += "\"Commodity name\":\"" + commodityEntity.getName() + "\",";
            JSON_String += "\"Commodity description\":\""  +  commodityEntity.getDescription() + "\",";
            JSON_String += "\"Unit\":\"" +  commodityEntity.getUnit() +"\",";
            JSON_String += "\"Price per unit\":\"" +  commodityEntity.getPrice() +"\",";
            JSON_String += "\"Provider\":\"" +  providersEntity.getName() +"\",";
            JSON_String += "\"City\":\"" +  providersEntity.getCity() +"\",";
            JSON_String += "\"Country\":\"" +  providersEntity.getCountry() +"\",";
            JSON_String += "\"Phone\":\"" +  providersEntity.getPhone() +"\",";
            JSON_String += "\"Fax\":\"" +  providersEntity.getFax() +"\",";
            JSON_String += "\"Is shipments are stopped?\":\"" +  (Entity.isShipments_are_stopped() ? "true" : "false") +"\",";
            JSON_String += "\"Count\":\"" +  Entity.getCount() +"\",";
            JSON_String += "\"Price\":\"" +  Entity.getPrice() +"\",";
            JSON_String += "\"Shipment time\":\"" +  Entity.getDate().toString() + "\"}";
        }
        JSON_String += "]";
        return JSON_String;
    }

    @RequestMapping(value = "/request_2", method = RequestMethod.GET)
    public
    @ResponseBody
    String Request2() {
        List<CommodityEntity> commodity_list = commodityService.getAll();
        List<SupplyEntity> supply_list = supplyService.getAll();

        String JSON_String = new String();
        JSON_String = "[";
        boolean isFirst = true;
        for(CommodityEntity Entity : commodity_list) {
            CommodityTypeEntity commodityTypeEntity = commodityTypeService.find(Entity.getType_id());
            if(isFirst) isFirst = false; else JSON_String +=",";
            JSON_String += "\"Commodity type\":\"" + commodityTypeEntity.getName() + "\",";
            JSON_String += "\"Commodity name\":\"" + Entity.getName() + "\",";
            int Count = 0;
            for(SupplyEntity SupplyEntity : supply_list) {if(SupplyEntity.getCommodity_id() == Entity.getId()){Count++;}}
            JSON_String += "\"Commodity count\":" + Count + ",";
            JSON_String += "\"Commodity description\":\"" + Entity.getDescription() + "\"}";
        }
        JSON_String += "]";
        return JSON_String;
    }

    @RequestMapping(value = "/request_2/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String Request2(@PathVariable Long id) {
        CommodityEntity commodity_entity = commodityService.find(id);
        String JSON_String = new String();
        JSON_String = "[";
        if(commodity_entity != null) {
            List<SupplyEntity> supply_list = supplyService.getAll();
            CommodityTypeEntity commodityTypeEntity = commodityTypeService.find(commodity_entity.getType_id());
            JSON_String += "\"Commodity type\":\"" + commodityTypeEntity.getName() + "\",";
            JSON_String += "\"Commodity name\":\"" + commodity_entity.getName() + "\",";
            int Count = 0;
            for (SupplyEntity SupplyEntity : supply_list) {
                if (SupplyEntity.getCommodity_id() == commodity_entity.getId()) {
                    Count++;
                }
            }
            JSON_String += "\"Commodity count\":" + Count + ",";
            JSON_String += "\"Commodity description\":\"" + commodity_entity.getDescription() + "\"}";
        }
        JSON_String += "]";
        return JSON_String;
    }


}
