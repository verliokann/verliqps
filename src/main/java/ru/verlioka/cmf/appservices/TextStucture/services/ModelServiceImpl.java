package ru.verlioka.cmf.appservices.TextStucture.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.TextStucture.dao.ModelsDao;
import ru.verlioka.cmf.appservices.TextStucture.Models.xModels;
import ru.verlioka.cmf.appservices.TextStucture.services.ModelService;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("ModelServiceImpl")
public class ModelServiceImpl extends GenericServiceImpl<xModels, Long>
        implements ModelService {

    public ModelServiceImpl () {
    }

    @Autowired
    public ModelServiceImpl (ModelsDao genericDao) {
        super(genericDao);
    }
}