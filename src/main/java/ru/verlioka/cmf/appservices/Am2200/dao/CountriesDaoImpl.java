package ru.verlioka.cmf.appservices.Am2200.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.Am2200.models.CountriesEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("countriesDaoImpl")
public class CountriesDaoImpl extends GenericDaoImpl<CountriesEntity, Integer> implements CountriesDao {
    public CountriesDaoImpl() {

    }
}
