package ru.verlioka.cmf.appservices.sales.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.sales.models.sotrudnikiEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("sotrudnikiDaoImpl")
public class sotrudnikiDaoImpl extends GenericDaoImpl<sotrudnikiEntity, Long>
        implements sotrudnikiDao {

}