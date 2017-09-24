package ru.verlioka.cmf.core.services.concrete.secure.db.roles;

import ru.verlioka.cmf.core.dao.concrete.secure.roles.IRoleDao;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;
import ru.verlioka.cmf.core.models.db.security.EntityRole;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends GenericServiceImpl<EntityRole, Integer>
implements IRoleService{

	private IRoleDao roleDao;
    
	public RoleServiceImpl(){
 
    }
    
    @Autowired    
    public RoleServiceImpl(@Qualifier("roleDaoImpl") IGenericDao<EntityRole, Integer> genericDao){
    	 super(genericDao);
         this.roleDao = (IRoleDao) genericDao;
    }
}
