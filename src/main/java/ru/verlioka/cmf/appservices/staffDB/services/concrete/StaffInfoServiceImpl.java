package ru.verlioka.cmf.appservices.staffDB.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.staffDB.dao.concrete.StaffInfoDao;
import ru.verlioka.cmf.appservices.staffDB.models.StaffInfoEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("staffinfoServiceImpl")
public class StaffInfoServiceImpl extends GenericServiceImpl<StaffInfoEntity, Long>
        implements StaffInfoService {

    public StaffInfoServiceImpl() {
    }

    @Autowired
    public StaffInfoServiceImpl(StaffInfoDao genericDao) {
        super(genericDao);
    }
}