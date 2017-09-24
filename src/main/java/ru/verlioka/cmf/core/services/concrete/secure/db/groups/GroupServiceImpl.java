package ru.verlioka.cmf.core.services.concrete.secure.db.groups;

import ru.verlioka.cmf.core.dao.concrete.secure.groups.IGroupDao;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;
import ru.verlioka.cmf.core.models.db.security.EntityGroup;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userGroupsService")
public class GroupServiceImpl extends GenericServiceImpl<EntityGroup, Integer>
implements IGroupService{

	private IGroupDao userGroupDao;
    
	public GroupServiceImpl(){
 
    }
    
    @Autowired    
    public GroupServiceImpl(@Qualifier("userGroupsDaoImpl") IGenericDao<EntityGroup, Integer> genericDao){
    	 super(genericDao);
         this.userGroupDao = (IGroupDao) genericDao;
    }
}
