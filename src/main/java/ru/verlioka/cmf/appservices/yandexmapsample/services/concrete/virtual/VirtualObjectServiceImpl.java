package ru.verlioka.cmf.appservices.yandexmapsample.services.concrete.virtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;
import ru.verlioka.cmf.appservices.yandexmapsample.dao.concrete.VirtualObjectDao;
import ru.verlioka.cmf.appservices.yandexmapsample.models.VirtualObject;

@Service("virtualObjectServiceImpl")
public class VirtualObjectServiceImpl extends GenericServiceImpl<VirtualObject, Long>
        implements VirtualObjectService {


    public VirtualObjectServiceImpl() {
    }


    @Autowired
    public VirtualObjectServiceImpl(VirtualObjectDao genericDao) {
        super(genericDao);
    }
}
