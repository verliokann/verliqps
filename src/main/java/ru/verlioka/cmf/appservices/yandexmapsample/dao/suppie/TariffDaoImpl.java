package ru.verlioka.cmf.appservices.yandexmapsample.dao.suppie;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.yandexmapsample.models.suppie.TariffEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

@Repository("tariffDaoImpl")
public class TariffDaoImpl extends GenericDaoImpl<TariffEntity, Long> implements TariffDao {
    public TariffDaoImpl() {
    }
}
