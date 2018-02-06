package ru.verlioka.cmf.appservices.mudrichenko.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.mudrichenko.models.InvestigatorsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("investigatorsDaoImpl")
public class InvestigatorsDaoImpl extends GenericDaoImpl<InvestigatorsEntity, Long>
        implements InvestigatorsDao {

}
