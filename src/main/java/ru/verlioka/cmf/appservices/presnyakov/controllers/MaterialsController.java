package ru.verlioka.cmf.appservices.presnyakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.appservices.presnyakov.models.Provider;
import ru.verlioka.cmf.appservices.presnyakov.services.City.CityService;
import ru.verlioka.cmf.appservices.presnyakov.services.Material.MaterialService;
import ru.verlioka.cmf.appservices.presnyakov.services.Provider.ProviderService;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual.VirtualObjectService;

import java.util.List;

@Controller
@RequestMapping("/presnyakov")
public class MaterialsController {

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/get_materials", method = RequestMethod.GET)
    public
    @ResponseBody
    String Request() {
        List<Material> material_list = materialService.getAll();
        String JSON_String = new String();
        JSON_String = "[";
        boolean isFirst = true;
        for(Material entity : material_list) {
            Provider provider = providerService.find(entity.getProvider_id());

            if(isFirst) isFirst = false; else JSON_String +=",";
            JSON_String += "{";
            JSON_String += "\"Batch number\":\"" + entity.getBatch_number() + "\",";
            JSON_String += "\"Cipher\":\""  +  entity.getCipher() + "\",";
            JSON_String += "\"Count\":\"" +  entity.getCount() +"\",";
            JSON_String += "\"Unit\":\"" +  entity.getUnit() +"\",";
            JSON_String += "\"Unit price\":\"" +  entity.getUnit_price() +"\",";
            JSON_String += "\"Date of receiving\":\"" +  entity.getDate_of_receiving().toString() +"\",";
            JSON_String += "\"Provider\":\"" +  provider.getName() +"\",";
            JSON_String += "\"Total price\":\"" +  entity.getCount()*entity.getUnit_price() + "\"}";
        }
        JSON_String += "]";
        return JSON_String;
    }

    @RequestMapping(value = "/get_material_info", method = RequestMethod.GET)
    public
    @ResponseBody
    String GetMaterialInfo() {
        List<Material> material_list = materialService.getAll();
        String JSON_String = new String();
        JSON_String = "[";
        boolean isFirst = true;
        for(Material entity : material_list) {
            Provider provider = providerService.find(entity.getProvider_id());
            City city = cityService.find(provider.getCity_id());

            if(isFirst) isFirst = false; else JSON_String +=",";
            JSON_String += "{";
            JSON_String += "\"Cipher\":\""  +  entity.getCipher() + "\",";
            JSON_String += "\"Provider name\":\"" +  provider.getName() +"\",";
            JSON_String += "\"Director\":\"" +  provider.getDirector() +"\",";
            JSON_String += "\"Provider city\":\"" +  city.getName() + "\"}";
        }
        JSON_String += "]";
        return JSON_String;
    }

    @RequestMapping(value = "/get_material_info/{id}", method = RequestMethod.GET)
    public
    @ResponseBody
    String GetMaterialInfoWIthID(@PathVariable long id) {
        Material material = materialService.find(id);
        if (material == null)
        {
            return "[]";
        }
        String JSON_String = new String();
        JSON_String = "[";

        Provider provider = providerService.find(material.getProvider_id());
        City city = cityService.find(provider.getCity_id());

        JSON_String += "{";
        JSON_String += "\"Cipher\":\""  +  material.getCipher() + "\",";
        JSON_String += "\"Provider name\":\"" +  provider.getName() +"\",";
        JSON_String += "\"Director\":\"" +  provider.getDirector() +"\",";
        JSON_String += "\"Provider city\":\"" +  city.getName() + "\"}";
        JSON_String += "]";
        return JSON_String;
    }
}
