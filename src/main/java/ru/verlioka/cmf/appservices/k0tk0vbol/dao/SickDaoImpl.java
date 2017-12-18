package ru.verlioka.cmf.appservices.k0tk0vbol.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.SickEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

/**
 * Created by Max on 13.12.2017.
 */
@Repository("sickDaoImpl")
public class SickDaoImpl extends GenericDaoImpl<SickEntity, Integer> implements SickDao {
}
