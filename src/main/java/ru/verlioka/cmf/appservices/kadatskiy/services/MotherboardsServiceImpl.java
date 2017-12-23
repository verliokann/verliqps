package ru.verlioka.cmf.appservices.kadatskiy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.kadatskiy.dao.MotherboardsDao;
import ru.verlioka.cmf.appservices.kadatskiy.models.Motherboards;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

/**
 * Created by Костя on 20.12.2017.
 */

@Service("motherboardsServiceImpl")
public class MotherboardsServiceImpl extends GenericServiceImpl<Motherboards, Long> implements MotherboardsService{
    private MotherboardsDao motherboardsDao;

    public MotherboardsServiceImpl() {
    }

    @Autowired
    public MotherboardsServiceImpl(MotherboardsDao genericDao) {
        super(genericDao);
    }

}

