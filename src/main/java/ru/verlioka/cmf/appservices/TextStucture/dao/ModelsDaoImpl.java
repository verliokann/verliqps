package ru.verlioka.cmf.appservices.TextStucture.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.TextStucture.Models.xModels;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("ModelsDaoImpl")
public class ModelsDaoImpl extends GenericDaoImpl<xModels, Long>
    implements ModelsDao
{
}
