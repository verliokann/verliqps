package ru.verlioka.cmf.appservices.TextStucture.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;
import ru.verlioka.cmf.appservices.TextStucture.Models.type_model;

@Repository("TypeModelDaoImpl")
public class TypeModelDaoImpl extends GenericDaoImpl<type_model, Long>
        implements TypeModelDao{
}
