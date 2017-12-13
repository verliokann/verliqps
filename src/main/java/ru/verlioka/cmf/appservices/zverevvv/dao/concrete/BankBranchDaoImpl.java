package ru.verlioka.cmf.appservices.zverevvv.dao.concrete;

import org.springframework.stereotype.Repository;
import ru.verlioka.cmf.appservices.zverevvv.models.BankBranchEntity;
import ru.verlioka.cmf.core.dao.generic.GenericDaoImpl;

import java.util.UUID;


@Repository("bankBranchDaoImpl")
public class BankBranchDaoImpl extends GenericDaoImpl<BankBranchEntity, UUID> implements BankBranchDao {

}
