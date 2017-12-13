package ru.verlioka.cmf.appservices.presnyakov.services.Material;


import ru.verlioka.cmf.appservices.presnyakov.models.City;
import ru.verlioka.cmf.appservices.presnyakov.models.Material;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface MaterialService extends IGenericService<Material, Long> {
    public List GetMaterialsCriteriaRequest();
    public List GetMaterialInfoCriteriaRequest();
    public List GetMaterialInfoRequest();
    public List GetMaterialsRequest();

}
