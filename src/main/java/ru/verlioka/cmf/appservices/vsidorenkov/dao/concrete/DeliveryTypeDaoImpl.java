package ru.verlioka.cmf.appservices.vsidorenkov.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.vsidorenkov.models.DeliveryType;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;


@Repository("DeliveryTypeDaoImpl")
public class DeliveryTypeDaoImpl extends GenericDaoImpl<DeliveryType, Long>
        implements DeliveryTypeDao {

}
