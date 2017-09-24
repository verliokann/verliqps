package ru.verlioka.cmf.core.dao.concrete.applications;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;
import ru.verlioka.cmf.core.models.db.security.EntityApp;


@Repository("appDaoImpl")
public class AppDaoImpl extends GenericDaoImpl<EntityApp, Integer>
								implements IAppDao{

}