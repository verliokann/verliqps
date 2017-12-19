package ru.verlioka.cmf.appservices.staffDB.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.staffDB.dao.concrete.DepartmentsDao;
import ru.verlioka.cmf.appservices.staffDB.models.DepartmentsEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("departmentsServiceImpl")
public class DepartmentsServiceImpl extends GenericServiceImpl<DepartmentsEntity, Long>
        implements DepartmentsService {

    public DepartmentsServiceImpl() {
    }

    @Autowired
    public DepartmentsServiceImpl(DepartmentsDao genericDao) {
        super(genericDao);
    }
}
