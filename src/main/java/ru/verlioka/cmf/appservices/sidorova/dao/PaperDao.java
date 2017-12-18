package ru.verlioka.cmf.appservices.sidorova.dao;

import ru.verlioka.cmf.appservices.sidorova.models.HelperModel;
import ru.verlioka.cmf.appservices.sidorova.models.PaperModel;
import ru.verlioka.cmf.core.dao.generic.IGenericDao;

import java.util.List;

public interface PaperDao extends IGenericDao <PaperModel,Integer> {
    public List<PaperModel> getPapers ();
    public List<PaperModel> getCompany();
    public List<HelperModel> getStocks();
    public List<PaperModel> getPapersCrit ();
    public List<PaperModel> gerCompanyCrit ();
}
