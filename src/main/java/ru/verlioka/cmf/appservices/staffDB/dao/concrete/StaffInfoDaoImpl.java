package ru.verlioka.cmf.appservices.staffDB.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.staffDB.models.StaffInfoEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("staffInfoDaoImpl")
public class StaffInfoDaoImpl extends GenericDaoImpl<StaffInfoEntity, Long>
        implements StaffInfoDao{
}

