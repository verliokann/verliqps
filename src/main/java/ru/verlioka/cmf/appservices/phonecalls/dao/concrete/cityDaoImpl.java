package ru.verlioka.cmf.appservices.phonecalls.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.phonecalls.models.cityEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("cityDaoImpl")
public class cityDaoImpl extends GenericDaoImpl<cityEntity, Long>
        implements cityDao {

}