package ru.verlioka.cmf.appservices.suppie.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.suppie.models.TariffEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("tariffDaoImpl")
public class TariffDaoImpl extends GenericDaoImpl<TariffEntity, Long> implements TariffDao {
    public TariffDaoImpl() {
    }
}
