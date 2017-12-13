package ru.verlioka.cmf.appservices.zverevvv.services.concrete;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.BankBranchReport;
import ru.verlioka.cmf.appservices.zverevvv.controllers.reports.CustomerReport;
import ru.verlioka.cmf.appservices.zverevvv.dao.concrete.BankBranchDao;
import ru.verlioka.cmf.appservices.zverevvv.dao.concrete.ClientDao;
import ru.verlioka.cmf.appservices.zverevvv.dao.concrete.DepositTypeDao;
import ru.verlioka.cmf.appservices.zverevvv.models.BankBranchEntity;
import ru.verlioka.cmf.appservices.zverevvv.models.ClientEntity;
import ru.verlioka.cmf.appservices.zverevvv.models.DepositTypeEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.UUID;

@Service("clientServiceImpl")
public class ClientServiceImpl extends GenericServiceImpl<ClientEntity, UUID> implements ClientService {
    private static final Logger log = LoggerFactory.getLogger(ClientService.class);

    private DepositTypeDao depositTypeDao;
    private BankBranchDao bankBranchDao;

    @PersistenceContext
    private EntityManager em;

    public ClientServiceImpl() {
    }

    @Autowired
    public ClientServiceImpl(ClientDao dao, DepositTypeDao depositTypeDao, BankBranchDao bankBranchDao) {
        super(dao);
        this.depositTypeDao = depositTypeDao;
        this.bankBranchDao = bankBranchDao;
    }

    public ClientDao getClientDao() {
        return (ClientDao) getGenericDao();
    }

    public DepositTypeDao getDepositTypeDao() {
        return depositTypeDao;
    }

    public BankBranchDao getBankBranchDao() {
        return bankBranchDao;
    }


    @Override
    public List<CustomerReport> getCustomersReportCriteria() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<CustomerReport> criteriaQuery = criteriaBuilder.createQuery(CustomerReport.class);
        Root<ClientEntity> clientEntityRoot = criteriaQuery.from(ClientEntity.class);
        Join<ClientEntity, DepositTypeEntity> depositTypeJoin = clientEntityRoot.join("depositInfo", JoinType.INNER);
        Join<ClientEntity, BankBranchEntity> bankBranchJoin = clientEntityRoot.join("bankBranchInfo", JoinType.INNER);
        criteriaQuery.multiselect(bankBranchJoin.get("address"),
                bankBranchJoin.get("details"),
                clientEntityRoot.get("name"),
                clientEntityRoot.get("account"),
                clientEntityRoot.get("amount"),
                depositTypeJoin.get("name"),
                clientEntityRoot.get("date"));

        TypedQuery<CustomerReport> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

    @Override
    public List<BankBranchReport> getBankBranchReportCriteria() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<BankBranchReport> criteriaQuery = criteriaBuilder.createQuery(BankBranchReport.class);
        Root<ClientEntity> clientEntityRoot = criteriaQuery.from(ClientEntity.class);
        Join<ClientEntity, DepositTypeEntity> depositTypeJoin = clientEntityRoot.join("depositInfo", JoinType.INNER);
        Join<ClientEntity, BankBranchEntity> bankBranchJoin = clientEntityRoot.join("bankBranchInfo", JoinType.INNER);
        criteriaQuery.multiselect(bankBranchJoin.get("number"),
                clientEntityRoot.get("name"),
                clientEntityRoot.get("account"),
                clientEntityRoot.get("date"),
                clientEntityRoot.get("amount"),
                depositTypeJoin.get("percents"),
                depositTypeJoin.get("duration"));

        TypedQuery<BankBranchReport> typedQuery = em.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }

    @Override
    public List<CustomerReport> getCustomersReportHQL() {
        TypedQuery<CustomerReport> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.zverevvv.controllers.reports.CustomerReport(bank_branch.address, bank_branch.details," +
                        " client.name, client.account, client.amount, deposit_type.name, client.date) from ClientEntity as client" +
                        " INNER JOIN client.bankBranchInfo as bank_branch INNER JOIN client.depositInfo as deposit_type",
                CustomerReport.class);

        return typedQuery.getResultList();
    }

    @Override
    public List<BankBranchReport> getBankBranchReportHQL() {
        TypedQuery<BankBranchReport> typedQuery = em.createQuery("select NEW ru.verlioka.cmf.appservices.zverevvv.controllers.reports.BankBranchReport(bank_branch.number, client.name," +
                " client.account, client.date, client.amount, deposit_type.percents, deposit_type.duration) from" +
                " ClientEntity as client INNER JOIN client.bankBranchInfo as bank_branch INNER JOIN client.depositInfo " +
                " as deposit_type", BankBranchReport.class);

        return typedQuery.getResultList();
    }
}
