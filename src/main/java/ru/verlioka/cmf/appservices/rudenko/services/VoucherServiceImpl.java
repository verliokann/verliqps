package ru.verlioka.cmf.appservices.rudenko.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.MidLengthVoucher;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VoucherReview;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersOverallReview;
import ru.verlioka.cmf.appservices.rudenko.controllers.json.VouchersWithVisaRequired;
import ru.verlioka.cmf.appservices.rudenko.dao.interfaces.VoucherDao;
import ru.verlioka.cmf.appservices.rudenko.models.VoucherEntity;
import ru.verlioka.cmf.core.services.generic.db.GenericServiceImpl;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Service("voucherService")
public class VoucherServiceImpl extends GenericServiceImpl<VoucherEntity, Long> implements VoucherService {
    public VoucherServiceImpl() {
    }

    @Autowired
    public VoucherServiceImpl(VoucherDao voucherDao) {
        super(voucherDao);
    }

    public VoucherDao getVoucherDao() {
        return (VoucherDao) getGenericDao();
    }

    @Override
    public List<MidLengthVoucher> getAllMidLengthVouchers(Integer lowerBound, Integer upperBound) {
        return getVoucherDao().getAll()
                .stream()
                .map(obj -> (VoucherEntity) obj)
                .filter(voucher -> (lowerBound <= voucher.getDays() && voucher.getDays() <= upperBound))
                .map(voucher -> {
                    MidLengthVoucher result = new MidLengthVoucher();
                    result.setVoucherId(voucher.getId());
                    result.setCountry(voucher.getHotel().getCountry().getName());
                    result.setDays(voucher.getDays());
                    result.setStart(voucher.getStart());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<VouchersWithVisaRequired> getVouchersWithVisaRequired() {
        Query q = getVoucherDao().getEntityManager().createQuery("from VoucherEntity");
        List<VoucherEntity> v = (List<VoucherEntity>) q.getResultList();

        return v.stream()
                .filter(voucher -> voucher.getHotel().getCountry().getVisaRequired())
                .map(voucher -> {
                    VouchersWithVisaRequired result = new VouchersWithVisaRequired();
                    result.setVoucherId(voucher.getId());
                    result.setCountryName(voucher.getHotel().getCountry().getName());
                    result.setHotelName(voucher.getHotel().getName());
                    result.setCost(voucher.getCost());
                    result.setStart(voucher.getStart());
                    result.setEnd(voucher.getEnd());
                    return result;
                })
                .collect(Collectors.toList());
    }

    @Override
    public VouchersOverallReview getVouchersReview() {
        List<VoucherReview> reviews = getVoucherDao().getAll()
                .stream()
                .map(obj -> (VoucherEntity) obj)
                .map(voucher -> {
                    VoucherReview result = new VoucherReview();
                    result.setId(voucher.getId());
                    result.setCost(voucher.getCost());
                    result.setFullCost(voucher.getCost() * 1.1);
                    return result;
                })
                .collect(Collectors.toList());

        VouchersOverallReview overallReview = new VouchersOverallReview();
        overallReview.setVouchers(reviews);
        overallReview.setOverallCost(reviews.stream().mapToDouble(VoucherReview::getCost).sum());
        overallReview.setOverallFullCost(reviews.stream().mapToDouble(VoucherReview::getFullCost).sum());
        return overallReview;
    }
}
