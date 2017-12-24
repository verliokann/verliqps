package ru.verlioka.cmf.appservices.kadatskiy.dao;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.kadatskiy.models.Motherboards;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.List;

/**
 * Created by Костя on 19.12.2017.
 */

    @Repository("motherboardsDaoImpl")
    public class MotherboardsDaoImpl extends GenericDaoImpl<Motherboards, Long> implements MotherboardsDao {

}
