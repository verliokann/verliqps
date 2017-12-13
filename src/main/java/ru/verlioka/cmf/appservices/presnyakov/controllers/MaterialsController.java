package ru.verlioka.cmf.appservices.presnyakov.controllers;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import ru.verlioka.cmf.appservices.presnyakov.controllers.Criteria.GetMaterialsCriteriaRequest;
import ru.verlioka.cmf.appservices.presnyakov.controllers.Criteria.GetMaterialsInfoCriteriaRequest;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.appservices.presnyakov.models.Provider;
import ru.verlioka.cmf.appservices.presnyakov.services.City.CityService;
import ru.verlioka.cmf.appservices.presnyakov.services.Material.MaterialService;
import ru.verlioka.cmf.appservices.presnyakov.services.Provider.ProviderService;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual.VirtualObjectService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    List GetMaterials() {
        return materialService.GetMaterialsRequest();
    }

    @RequestMapping(value = "/get_materials_criteria", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetMaterialsCriteria() {
        return materialService.GetMaterialsCriteriaRequest();
    }

    @RequestMapping(value = "/get_material_info", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetMaterialInfo() {
        return materialService.GetMaterialInfoRequest();
    }

    @RequestMapping(value = "/get_material_info_criteria", method = RequestMethod.GET)
    public
    @ResponseBody
    List GetMaterialInfoCriteria() {
        return materialService.GetMaterialInfoCriteriaRequest();
    }
}
