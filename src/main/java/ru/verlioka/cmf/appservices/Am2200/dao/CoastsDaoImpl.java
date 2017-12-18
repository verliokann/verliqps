package ru.verlioka.cmf.appservices.Am2200.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.Am2200.models.CoastsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("coastsDaoImpl")
public class CoastsDaoImpl extends GenericDaoImpl<CoastsEntity, Integer> implements CoastsDao {
    public CoastsDaoImpl() {

    }
}
