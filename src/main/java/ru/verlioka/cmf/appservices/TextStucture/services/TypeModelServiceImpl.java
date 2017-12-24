package ru.verlioka.cmf.appservices.TextStucture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.TextStucture.Models.type_model;
import ru.verlioka.cmf.appservices.TextStucture.dao.TypeModelDao;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("TypeModelServiceImpl")
public class TypeModelServiceImpl extends GenericServiceImpl<type_model, Long>
    implements TypeModelService{

    public TypeModelServiceImpl(){}

    @Autowired
    public TypeModelServiceImpl(TypeModelDao genericDao) {super(genericDao);}
}
