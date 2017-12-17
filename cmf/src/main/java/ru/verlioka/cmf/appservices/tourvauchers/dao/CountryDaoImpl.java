package ru.verlioka.cmf.appservices.tourvauchers.dao;

import org.springframework.stereotype.Repository;

import ru.verlioka.cmf.appservices.tourvauchers.models.CountryEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("countryDaoImpl")
public class CountryDaoImpl extends GenericDaoImpl<CountryEntity, Long> implements CountryDao {
    public CountryDaoImpl() {
    }
}

