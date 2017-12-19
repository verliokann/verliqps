package ru.verlioka.cmf.appservices.staffDB.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.staffDB.models.TimeSheetEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("timeSheetDaoImpl")
public class TimeSheetDaoImpl extends GenericDaoImpl<TimeSheetEntity, Long>
        implements TimeSheetDao{
}