package ru.verlioka.cmf.appservices.k0tk0vbol.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.DeptEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

/**
 * Created by Max on 13.12.2017.
 */
@Repository("dapartnmentDaoImpl")
public class DepartmentDaoImpl extends GenericDaoImpl<DeptEntity, Integer> implements DepartmentDao {
}
