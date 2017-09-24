package ru.verlioka.cmf.appservices.yandexmapsample.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;


@Repository("virtualObjectDaoImpl")
public class VirtualObjectDaoImpl extends GenericDaoImpl<VirtualObject, Long>
        implements VirtualObjectDao {

}
