package ru.verlioka.cmf.appservices.decay.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.decay.model.jobEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("jobcommodityDaoImpl")
public class jobDaoImpl extends GenericDaoImpl <jobEntity, Long>
        implements jobDao {

}
