package ru.verlioka.cmf.appservices.roglik.dao.impl;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.roglik.dao.interfaces.HotelDao;
import ru.verlioka.cmf.appservices.roglik.models.HotelEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("hotelDaoImpl")
public class HotelDaoImpl extends GenericDaoImpl<HotelEntity, Long> implements HotelDao {
    public HotelDaoImpl() {
    }
}
