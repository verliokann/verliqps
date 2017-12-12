package ru.verlioka.cmf.appservices.negotiations.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.negotiations.models.NegotiationsTable;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("NegotiationsDaoImpl")

public class NegotiationsDaoImpl extends GenericDaoImpl<NegotiationsTable, Long>
        implements NegotiationsDao {
}
