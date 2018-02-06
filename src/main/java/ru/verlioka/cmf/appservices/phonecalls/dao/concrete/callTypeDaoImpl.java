package ru.verlioka.cmf.appservices.phonecalls.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.phonecalls.models.callTypeEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("callTypeDaompl")
public class callTypeDaoImpl extends GenericDaoImpl<callTypeEntity, Long>
        implements callTypeDao {

}