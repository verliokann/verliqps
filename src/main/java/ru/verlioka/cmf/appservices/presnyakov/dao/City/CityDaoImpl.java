package ru.verlioka.cmf.appservices.presnyakov.dao.City;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("cityDaoImpl")
public class CityDaoImpl extends GenericDaoImpl<City, Long>
        implements CityDao {

}
