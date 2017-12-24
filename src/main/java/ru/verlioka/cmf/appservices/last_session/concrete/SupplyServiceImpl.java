package ru.verlioka.cmf.appservices.last_session.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.last_session.model.SupplyEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("supplyServiceImpl")
public class SupplyServiceImpl extends GenericServiceImpl<SupplyEntity, Long>
        implements SupplyService {

    public SupplyServiceImpl() {
    }

    @Autowired
    public SupplyServiceImpl(SupplyDao genericDao) {
        super(genericDao);
    }
}
