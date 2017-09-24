package ru.verlioka.cmf.core.dao.concrete.secure.roles;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;
import ru.verlioka.cmf.core.models.db.security.EntityRole;


@Repository("roleDaoImpl")
public class RoleDaoImpl extends GenericDaoImpl<EntityRole, Integer>
								implements IRoleDao{

}