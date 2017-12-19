package ru.verlioka.cmf.appservices.staffDB.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.staffDB.dao.concrete.TimeSheetDao;
import ru.verlioka.cmf.appservices.staffDB.models.TimeSheetEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("timesheetServiceImpl")
public class TimeSheetServiceImpl extends GenericServiceImpl<TimeSheetEntity, Long>
        implements TimeSheetService {

    public TimeSheetServiceImpl() {
    }

    @Autowired
    public TimeSheetServiceImpl(TimeSheetDao genericDao) {
        super(genericDao);
    }
}
