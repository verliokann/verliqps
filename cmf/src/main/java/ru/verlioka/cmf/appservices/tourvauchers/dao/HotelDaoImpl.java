package ru.verlioka.cmf.appservices.tourvauchers.dao;

import org.springframework.stereotype.Repository;

import ru.verlioka.cmf.appservices.tourvauchers.models.HotelEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("hotelDaoImpl")
public class HotelDaoImpl extends GenericDaoImpl<HotelEntity, Long> implements HotelDao {
    public HotelDaoImpl() {
    }
}
