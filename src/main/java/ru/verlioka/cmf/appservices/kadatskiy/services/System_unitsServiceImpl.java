package ru.verlioka.cmf.appservices.kadatskiy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.kadatskiy.dao.System_unitsDao;
import ru.verlioka.cmf.appservices.kadatskiy.models.System_units;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

/**
 * Created by Костя on 20.12.2017.
 */

@Service("system_unitsServiceImpl")
public class System_unitsServiceImpl extends GenericServiceImpl<System_units, Long> implements System_unitsService{
    private System_unitsDao system_unitsDao;

    public System_unitsServiceImpl() {

    }

    @Autowired
    public System_unitsServiceImpl(System_unitsDao genericDao){
        super(genericDao);
    }

}
