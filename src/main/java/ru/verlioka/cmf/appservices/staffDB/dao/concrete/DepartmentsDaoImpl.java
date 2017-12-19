package ru.verlioka.cmf.appservices.staffDB.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.staffDB.models.DepartmentsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("departmentsDaoImpl")
public class DepartmentsDaoImpl extends GenericDaoImpl<DepartmentsEntity, Long>
        implements DepartmentsDao{
}
