package ru.verlioka.cmf.appservices.presnyakov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.appservices.presnyakov.services.Material.MaterialService;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual.VirtualObjectService;

import java.util.List;

@Controller
@RequestMapping("/presnyakov")
public class MaterialsController {

    @Autowired
    private MaterialService materialService;
}
