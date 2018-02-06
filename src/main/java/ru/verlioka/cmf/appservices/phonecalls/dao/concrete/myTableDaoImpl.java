package ru.verlioka.cmf.appservices.phonecalls.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.phonecalls.models.myTableEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("myTableDaoImpl")
public class myTableDaoImpl extends GenericDaoImpl<myTableEntity, Long>
        implements myTableDao {

}