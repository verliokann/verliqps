package ru.verlioka.cmf.appservices.zverevvv.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.zverevvv.models.DepositTypeEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.UUID;


@Repository("depositTypeDaoImpl")
public class DepositTypeDaoImpl extends GenericDaoImpl<DepositTypeEntity, UUID> implements DepositTypeDao {

}
