package ru.verlioka.cmf.appservices.criminal.services.concrete.virtual;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;
import ru.verlioka.cmf.appservices.criminal.dao.concrete.CriminalDao;
import ru.verlioka.cmf.appservices.criminal.models.Criminal;

@Service("criminalServiceImpl")
public class CriminalServiceImpl extends GenericServiceImpl<Criminal, Long>
        implements CriminalService {


    public CriminalServiceImpl() {
    }

    @Autowired
    public CriminalServiceImpl(CriminalDao genericDao) {
        super(genericDao);
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
	public List getNotProccessed()
	{
		  String str = "select count(*) from criminal where isprocessed=0";
		  Session session = ((Session) entityManager.getDelegate()).getSessionFactory().openSession();
		  Query query = session.createQuery(str);
		  return query.list();
	}
}

