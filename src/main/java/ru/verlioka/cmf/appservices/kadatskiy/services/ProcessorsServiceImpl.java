package ru.verlioka.cmf.appservices.kadatskiy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.kadatskiy.dao.ProcessorsDao;
import ru.verlioka.cmf.appservices.kadatskiy.models.Processors;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

/**
 * Created by Костя on 16.12.2017.
 */

@Service("processorsServiceImpl")
public class ProcessorsServiceImpl extends GenericServiceImpl <Processors, Long> implements ProcessorsService{
    private ProcessorsDao processorsDao;

    public ProcessorsServiceImpl() {
    }

    @Autowired
    public ProcessorsServiceImpl(ProcessorsDao genericDao) {
        super(genericDao);
    }
}
