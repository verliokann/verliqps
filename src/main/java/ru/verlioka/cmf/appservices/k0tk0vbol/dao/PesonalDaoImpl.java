package ru.verlioka.cmf.appservices.k0tk0vbol.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.k0tk0vbol.models.PersonalEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

/**
 * Created by Max on 13.12.2017.
 */
@Repository("personlaDaoImpl")
public class PesonalDaoImpl extends GenericDaoImpl<PersonalEntity, Integer> implements PersonalDao {
}
