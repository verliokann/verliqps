package ru.verlioka.cmf.appservices.vsidorenkov.services.concrete.orders;


import ru.verlioka.cmf.appservices.vsidorenkov.models.Orders;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface OrdersService extends IGenericService<Orders, Long> {
    public List GetRequest1();
    public List GetRequest2();
    public List GetCriteriaRequest1();
    public List GetCriteriaRequest2();
}
