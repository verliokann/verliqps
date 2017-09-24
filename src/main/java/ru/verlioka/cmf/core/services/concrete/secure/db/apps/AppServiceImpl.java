package ru.verlioka.cmf.core.services.concrete.secure.db.apps;

import ru.verlioka.cmf.core.dao.concrete.applications.IAppDao;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;
import ru.verlioka.cmf.core.models.db.security.EntityApp;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("appService")
public class AppServiceImpl extends GenericServiceImpl<EntityApp, Integer>
implements IAppService{

	private IAppDao appDao;    
	public AppServiceImpl(){
 
    }
    
    @Autowired    
    public AppServiceImpl(@Qualifier("appDaoImpl") IGenericDao<EntityApp, Integer> genericDao){
    	 super(genericDao);
         this.appDao = (IAppDao) genericDao;
    }
}
