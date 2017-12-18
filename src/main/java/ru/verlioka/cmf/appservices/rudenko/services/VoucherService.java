package ru.verlioka.cmf.appservices.rudenko.services;

import ru.verlioka.cmf.appservices.rudenko.controllers.json.MidLengthVoucher;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersOverallReview;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersWithVisaRequired;
import ru.verlioka.cmf.appservices.rudenko.models.VoucherEntity;
import ru.verlioka.cmf.core.services.generic.db.IGenericService;

import java.util.List;

public interface VoucherService extends IGenericService<VoucherEntity, Long> {
    List<MidLengthVoucher> getAllMidLengthVouchers(Integer lowerBound, Integer upperBound);

    List<VouchersWithVisaRequired> getVouchersWithVisaRequired();

    VouchersOverallReview getVouchersReview();
}
