package ru.verlioka.cmf.appservices.presnyakov.services.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.presnyakov.dao.City.CityDao;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.concrete.VirtualObjectDao;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("cityServiceImpl")
public class CityServiceImpl extends GenericServiceImpl<City, Long>
        implements CityService {


    public CityServiceImpl() {
    }

    @Autowired
    public CityServiceImpl(CityDao genericDao) {
        super(genericDao);
    }
}
