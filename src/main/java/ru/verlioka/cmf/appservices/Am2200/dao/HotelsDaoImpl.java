package ru.verlioka.cmf.appservices.Am2200.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.Am2200.models.HotelsEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("hotelsDaoImpl")
public class HotelsDaoImpl extends GenericDaoImpl<HotelsEntity, Integer> implements HotelsDao {
    public HotelsDaoImpl() {

    }
}
