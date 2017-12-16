package ru.verlioka.cmf.appservices.sidorova.services.paper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.sidorova.dao.PaperDao;
import ru.verlioka.cmf.appservices.sidorova.models.HelperModel;
import ru.verlioka.cmf.appservices.sidorova.models.PaperModel;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import java.util.List;

@Service ("paperService")
public class PaperServiceImpl extends GenericServiceImpl <PaperModel,Integer> implements PaperService {

    private PaperDao paperDao;

    public PaperServiceImpl() {
    }

    @Autowired
    public PaperServiceImpl(@Qualifier ("paperDaoImpl") IGenericDao<PaperModel, Integer> genericDao) {
        super(genericDao);
        this.paperDao = (PaperDao) genericDao;
    }

    @Override
    public List<PaperModel> getPapers() {
        return paperDao.getPapers();
    }

    @Override
    public List<PaperModel> getCompany() {
        return paperDao.getCompany();
    }

    @Override
    public List<HelperModel> getStocks() {
        return paperDao.getStocks();
    }

    @Override
    public List<PaperModel> getPapersCrit() {
        return paperDao.getPapersCrit();
    }

    @Override
    public List<PaperModel> gerCompanyCrit() {
        return paperDao.gerCompanyCrit();
    }

}
