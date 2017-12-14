package ru.verlioka.cmf.appservices.criminal.dao.concrete;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;
import ru.verlioka.cmf.appservices.criminal.models.Criminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Repository("criminalDaoImpl")

public class CriminalDaoImpl extends GenericDaoImpl<Criminal, Long>
        implements CriminalDao {
}
