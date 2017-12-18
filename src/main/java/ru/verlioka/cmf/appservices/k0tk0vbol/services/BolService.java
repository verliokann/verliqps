package ru.verlioka.cmf.appservices.k0tk0vbol.services;

import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.DepartInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.controllers.reports.SickInfReq;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.DeptEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

/**
 * Created by Max on 14.12.2017.
 */
public interface BolService extends IGenericService<DeptEntity, Integer> {
    List<SickInfReq> getBolstaffHQL();
    List<SickInfReq> getBolStaffCriteria();

    List<DepartInfReq> getDepartStaffHQL();
    List<DepartInfReq> getDepartStaffCriteria();


}
