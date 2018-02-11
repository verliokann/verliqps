package ru.verlioka.cmf.appservices.sales.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.sales.models.prodazhiEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("prodazhiDaoImpl")
public class prodazhiDaoImpl extends GenericDaoImpl<prodazhiEntity, Long>
        implements prodazhiDao {

}