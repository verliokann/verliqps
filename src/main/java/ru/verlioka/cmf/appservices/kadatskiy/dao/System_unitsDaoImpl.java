package ru.verlioka.cmf.appservices.kadatskiy.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.kadatskiy.models.System_units;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

/**
 * Created by Костя on 19.12.2017.
 */

@Repository("System_unitsDaoImpl")
public class System_unitsDaoImpl extends GenericDaoImpl<System_units, Long> implements System_unitsDao {

}
