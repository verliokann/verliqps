package ru.verlioka.cmf.appservices.presnyakov.dao.Material;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.concrete.VirtualObjectDao;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("materialDaoImpl")
public class MaterialDaoImpl extends GenericDaoImpl<Material, Long>
        implements MaterialDao {

}
