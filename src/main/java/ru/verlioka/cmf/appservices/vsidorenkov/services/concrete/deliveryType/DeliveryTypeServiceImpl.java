package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.deliveryType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete.DeliveryTypeDao;
import ru.verlioka.cmf.appservices.vsidorenkov.models.DeliveryType;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

@Service("DeliveryTypeServiceImpl")
public class DeliveryTypeServiceImpl extends GenericServiceImpl<DeliveryType, Long>
        implements DeliveryTypeService {


    public DeliveryTypeServiceImpl() {
    }

    @Autowired
    public DeliveryTypeServiceImpl(DeliveryTypeDao genericDao) {
        super(genericDao);
    }
}
