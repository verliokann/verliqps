package ru.verlioka.cmf.appservices.rudenko.dao.impl;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.rudenko.dao.interfaces.CountryDao;
import ru.verlioka.cmf.appservices.rudenko.models.CountryEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("countryDaoImpl")
public class CountryDaoImpl extends GenericDaoImpl<CountryEntity, Long> implements CountryDao {
    public CountryDaoImpl() {
    }
}
