package ru.verlioka.cmf.appservices.sidorova.services.paper;

import ru.verlioka.cmf.appservices.sidorova.models.HelperModel;
import ru.verlioka.cmf.appservices.sidorova.models.PaperModel;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface PaperService extends IGenericService <PaperModel,Integer> {
    public List<PaperModel> getPapers ();
    public List<PaperModel> getCompany();
    public List<HelperModel> getStocks();
    public List<PaperModel> getPapersCrit();
    public List<PaperModel> gerCompanyCrit ();
}
