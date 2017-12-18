package ru.verlioka.cmf.appservices.Am2200.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.Am2200.models.TypesOfCoastsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("typesOfCoastsDaoImpl")
public class TypesOfCoastsDaoImpl extends GenericDaoImpl<TypesOfCoastsEntity, Integer> implements TypesOfCoastsDao{
    public TypesOfCoastsDaoImpl() {

    }
}
