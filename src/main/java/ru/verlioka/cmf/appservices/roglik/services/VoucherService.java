package ru.verlioka.cmf.appservices.roglik.services;

import ru.verlioka.cmf.appservices.roglik.controllers.json.BeachTypes;
import ru.verlioka.cmf.appservices.roglik.controllers.json.CertainBeachVouchers;
import ru.verlioka.cmf.appservices.roglik.controllers.json.LowCostVouchers;
import ru.verlioka.cmf.appservices.roglik.models.VoucherEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface VoucherService extends IGenericService<VoucherEntity, Long> {
    List<LowCostVouchers> getVouchersBelowCertainPrice(Integer price);

    CertainBeachVouchers getVouchersByBeachType(String beachType);

    List<BeachTypes> getBeachReport();
}
