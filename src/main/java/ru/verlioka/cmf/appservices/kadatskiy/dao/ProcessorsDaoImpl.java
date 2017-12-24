package ru.verlioka.cmf.appservices.kadatskiy.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.kadatskiy.models.Processors;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.List;

/**
 * Created by Костя on 16.12.2017.
 */

    @Repository("processorsDaoImpl")
    public class ProcessorsDaoImpl extends GenericDaoImpl<Processors, Long> implements ProcessorsDao {

}

