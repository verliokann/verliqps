package ru.verlioka.cmf.appservices.presnyakov.services.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.presnyakov.dao.City.CityDao;
import ru.verlioka.cmf.appservices.presnyakov.dao.Material.MaterialDao;
import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("materialServiceImpl")
public class MaterialServiceImpl extends GenericServiceImpl<Material, Long>
        implements MaterialService {


    public MaterialServiceImpl() {
    }

    @Autowired
    public MaterialServiceImpl(MaterialDao genericDao) {
        super(genericDao);
    }
}
