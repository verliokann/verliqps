package ru.verlioka.cmf.appservices.mudrichenko.services.concrete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.mudrichenko.dao.concrete.InvestigatorsDao;
import ru.verlioka.cmf.appservices.mudrichenko.models.InvestigatorsEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("investigatorsServiceImpl")
public class InvestigatorsServiceImpl extends GenericServiceImpl<InvestigatorsEntity, Long>
        implements InvestigatorsService {


    public InvestigatorsServiceImpl() {
    }

    @Autowired
    public InvestigatorsServiceImpl(InvestigatorsDao genericDao) {
        super(genericDao);
    }
}
